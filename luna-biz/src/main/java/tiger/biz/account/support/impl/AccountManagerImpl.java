/**
 * 404 Studio Inc.
 * Copyright (c) 2014-2015 All Rights Reserved.
 */
package tiger.biz.account.support.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tiger.biz.account.support.AccountManager;
import tiger.common.dal.enums.AttachTypeEnum;
import tiger.common.dal.persistence.account.query.AccountQuery;
import tiger.common.dal.persistence.attach.query.AttachQuery;
import tiger.common.dal.redis.RedisComponent;
import tiger.common.util.DateUtil;
import tiger.common.util.FileUtil;
import tiger.common.util.PhoneUtil;
import tiger.common.util.StringUtil;
import tiger.core.basic.BaseResult;
import tiger.core.basic.constants.SystemConstants;
import tiger.core.basic.enums.ErrorCodeEnum;
import tiger.core.basic.exception.TigerException;
import tiger.core.domain.account.AccountDomain;
import tiger.core.domain.account.AccountLoginLogDomain;
import tiger.core.domain.account.AccountSignUpDomain;
import tiger.core.domain.account.convert.AccountConvert;
import tiger.core.domain.attach.AttachDomain;
import tiger.core.service.account.AccountService;
import tiger.core.service.account.LoginLogService;
import tiger.core.service.attach.QiniuAttachService;
import tiger.core.service.system.InvitationCodeService;
import tiger.core.service.system.SystemParamService;
import tiger.core.service.workspace.WorkspaceService;
import tiger.biz.base.util.PasswordEncryptUtil;

import java.util.*;

/**
 * 用户基本服务
 *
 * @author yiliang.gyl
 * @version v 0.1 Sep 10, 2015 9:42:26 PM yiliang.gyl Exp $
 */
@Service
public class AccountManagerImpl implements AccountManager {
    Logger logger = Logger.getLogger(AccountManagerImpl.class);

    @Autowired
    AccountService accountService;

    @Autowired
    LoginLogService loginLogService;

    @Autowired
    QiniuAttachService qiniuAttachService;

    @Autowired
    SystemParamService systemParamService;

    @Autowired
    InvitationCodeService invitationCodeService;

    @Autowired
    RedisComponent redisComponent;

    @Autowired
    WorkspaceService workspaceService;

    /**
     * @see AccountManager#hasBindMobile(Long)
     */
    @Override
    public Boolean hasBindMobile(Long accountId) {
        AccountDomain accountDomain = accountService.read(accountId);

        if (accountDomain == null) {
            throw new TigerException(ErrorCodeEnum.NOT_FOUND, "不存在的账户");
        }

        // 如果手机号不是valid
        return PhoneUtil.isValidMobile(accountDomain.getMobile());
    }

    /**
     * 手机号和密码登录
     *
     * @param mobile
     * @param password
     * @return
     */
    @Override
    public AccountDomain login(String mobile, String password) {
        AccountDomain accountDomain = accountService.readByMobile(mobile);
        // 检验手机号码是否注册
        if (accountDomain == null) {
            throw new TigerException(ErrorCodeEnum.NOT_FOUND, "未注册的手机号码");
        }
        // 检验账户设置
        if (!StringUtil.equals(mobile, accountDomain.getMobile())) {
            throw new TigerException(ErrorCodeEnum.BIZ_FAIL);
        }
        // 检验密码
        if (StringUtil.equals(password, PasswordEncryptUtil.getLoginPassword(accountDomain.getPassword(),
                mobile, PasswordEncryptUtil.SBIN))) {
            // 设置头像信息, 公司信息
            accountDomain = setCompanyAndIcon(accountDomain);

            return accountDomain;
        }

        throw new TigerException(ErrorCodeEnum.BIZ_FAIL, "手机号码密码不匹配");
    }

    /**
     * Login by token.
     *
     * @param token the token
     * @return the account vo
     */
    @Override
    public AccountDomain loginByToken(String token) {
        //根据token获取用户id
        Long accountId = loginLogService.getAccountIdByToken(token);
        //如果用户id存在则返回用户领域模型
        if (accountId == null) {
            return null;
        }
        return accountService.readWithPermissions(accountId);
    }

    /**
     * 生成token
     * 保存登录记录
     */
    @Override
    public String createToken(AccountLoginLogDomain loginLogDomain, int expireDay) {
        if (null == loginLogDomain || expireDay < 0) {
            throw new TigerException(ErrorCodeEnum.ILLEGAL_PARAMETER_VALUE);
        }
        // TODO 1. token生成策略升级；2. 缓存增加
        String token = StringUtil.createToken();
        loginLogDomain.setToken(token);
        loginLogDomain.setExpireTime(DateUtil.addDays(new Date(), expireDay));
        loginLogService.createLog(loginLogDomain);
        return token;
    }

    /**
     * 添加用户，并添加对应的公司信息
     *
     * @param account
     * @return
     */
    @Override
    @Transactional
    public AccountDomain signup(AccountSignUpDomain account) {

        // 1. 添加空的公司信息
        // 2. 关联新建的账户与公司
        AccountDomain accountDomain = AccountConvert.convertAccountSignUpDomainToAccountDomain(account);
        accountDomain.setIconId(accountService.getDefaultIconId());

        accountDomain = accountService.addAccount(accountDomain);

        return accountDomain;
    }

    /**
     * 关联用户头像业务
     *
     * @param accountId
     * @param attachId
     * @return
     */
    @Override
    public BaseResult<Boolean> attachToAccountHeader(Long accountId, Long attachId) {
        // 判断attachId是否存在
        if (!qiniuAttachService.isExist(attachId)) {
            return new BaseResult<>(ErrorCodeEnum.NOT_FOUND, false);
        }
        // 判断accountId是否为attachId的所有者
        if (!qiniuAttachService.isOwner(attachId, accountId)) {
            return new BaseResult<>(ErrorCodeEnum.UNAUTHORIZED, false);
        }
        // 判断attachId是否为公开附件
        if (!qiniuAttachService.isAttachType(attachId, AttachTypeEnum.PUBLIC)) {
            return new BaseResult<>(ErrorCodeEnum.ILLEGAL_PARAMETER_VALUE, false);
        }
        // 检查attachId是否为图像
        AttachDomain attachDomain = qiniuAttachService.read(attachId);
        if (!FileUtil.isImageFileFromName(attachDomain.getName())) {
            return new BaseResult<>(ErrorCodeEnum.BIZ_UNSUPPORTED_KIND, false);
        }

        if (accountService.updateAccountHeaderIcon(accountId, attachId) > 0) {
            return new BaseResult<>(true);
        } else {
            return new BaseResult<>(ErrorCodeEnum.BIZ_FAIL, false);
        }
    }


    /**
     * 更新用户信息
     *
     * @param domain
     * @return
     */
    @Override
    public BaseResult<AccountDomain> updateAccountDomain(AccountDomain domain) {
        if (logger.isInfoEnabled()) {
            logger.info("更新用户 " + domain.getId() + " 信息, 收到的参数为: [" + domain + "]");
        }
        AccountDomain oldAccount = accountService.read(domain.getId());
        if (oldAccount == null) {
            logger.error("更新的用户 " + domain.getId() + " 不存在, 收到的参数为: [" + domain + "]");
            return new BaseResult<>(ErrorCodeEnum.NOT_FOUND.getCode(), "不存在的用户");
        }

        HashMap<String, String> oldExtParams = oldAccount.getExtParams();
        if (null == oldExtParams) {
            oldExtParams = new HashMap<>();
        }
        oldExtParams.putAll(domain.getExtParams());

        domain.setExtParams(oldExtParams);

        if (!accountService.updateAccount(domain)) {
            logger.error("保存用户更新失败, 收到的参数为: [" + domain + "]");
            return new BaseResult<>(ErrorCodeEnum.BIZ_FAIL);
        }

        return new BaseResult<>(accountService.read(domain.getId()));
    }

    @Override
    public List<AccountDomain> getAccountsByIds(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return new ArrayList<>();
        }

        // 构建AccountQuery,查询客户信息
        AccountQuery accountQuery = new AccountQuery();
        accountQuery.setIds(ids);

        List<AccountDomain> accountDomains = accountService.queryAll(accountQuery);
        return setCompaniesAndIcons(accountDomains);
    }

    @Override
    public AccountDomain readAccount(Long id) {
        return accountService.read(id);
    }

    /**
     * @param accountId
     * @return
     * @see AccountManager#checkAndGetAccount(Long)
     */
    @Override
    public AccountDomain checkAndGetAccount(Long accountId) {
        AccountDomain accountDomain = accountService.read(accountId);

        if (accountDomain == null) {
            logger.error("账户 [" + accountId + "] 不存在");
            throw new TigerException(ErrorCodeEnum.NOT_FOUND);
        }

        return accountDomain;
    }

    /**
     * 设置头像和公司
     *
     * @param account
     * @return
     */
    @Override
    public AccountDomain setCompanyAndIcon(AccountDomain account) {
        try {
            // 设置头像信息, 公司信息
            List<AccountDomain> accountDomains = new ArrayList<>(SystemConstants.SIZE_ONE);
            accountDomains.add(account);
            account = setCompaniesAndIcons(accountDomains).get(SystemConstants.FIRST_INDEX);
            return account;
        } catch (Exception e) {
            logger.error("获取头像和公司时发生错误:[" + account + "]");
            return account;
        }
    }

    @Override
    public List<AccountDomain> setCompaniesAndIcons(List<AccountDomain> accounts) {
        try {
            return setAccountIcons(accounts);
        } catch (Exception e) {
            logger.error("获取头像和公司时发生错误, 参数为:[" + accounts + "]");
            return accounts;
        }
    }

    // ~ Private Method


    /**
     * 设置accountDomains的头像信息
     *
     * @param accountDomains
     * @return
     */
    private List<AccountDomain> setAccountIcons(List<AccountDomain> accountDomains) {
        // 如果查询结果为空,提前结束
        if (CollectionUtils.isEmpty(accountDomains)) {
            return accountDomains;
        }

        List<Long> attachIds = new ArrayList<>(accountDomains.size());

        accountDomains.forEach(accountDomain -> {
            // 添加头像ids
            if (accountDomain.getIconId() != null) {
                attachIds.add(accountDomain.getIconId());
            }
        });

        // 构建AttachQuery查询 头像信息
        AttachQuery attachQuery = new AttachQuery();
        attachQuery.setIds(attachIds);
        List<AttachDomain> iconDomains = qiniuAttachService.query(attachQuery);

        Map<Long, AttachDomain> iconDomainMap = new HashMap<>(iconDomains.size());

        // 构建HashMap,方便查找
        iconDomains.forEach(iconDomain -> iconDomainMap.put(iconDomain.getId(), qiniuAttachService.getAttachWithSignedUrl(iconDomain)));

        // 设置头像
        accountDomains.forEach(accountDomain -> {
            if (accountDomain.getIconId() != null) {
                AttachDomain attachDomain = iconDomainMap.get(accountDomain.getIconId());
                // 检查头像参数
                if (AttachTypeEnum.PUBLIC.equals(attachDomain.getAttachType()) && FileUtil.isImageFileFromName(attachDomain.getName())) {
                    accountDomain.setIcon(attachDomain);
                } else {
                    logger.error("用户[ " + accountDomain + " ]头像设置错误");
                }
            }
        });

        return accountDomains;
    }
}
