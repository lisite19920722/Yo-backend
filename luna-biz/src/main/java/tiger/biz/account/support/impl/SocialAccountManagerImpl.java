/**
 * 404 Studio Inc.
 * Copyright (c) 2014-2015 All Rights Reserved.
 */
package tiger.biz.account.support.impl;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.biz.account.support.AccountManager;
import tiger.biz.account.support.SocialAccountManager;
import tiger.common.dal.enums.AccountSocialTypeEnum;
import tiger.common.dal.enums.AttachTypeEnum;
import tiger.common.dal.enums.SystemParamTypeEnum;
import tiger.common.util.FileUtil;
import tiger.common.util.StringUtil;
import tiger.core.basic.BaseResult;
import tiger.core.basic.enums.ErrorCodeEnum;
import tiger.core.basic.exception.TigerException;
import tiger.core.domain.account.AccountBindDomain;
import tiger.core.domain.account.AccountDomain;
import tiger.core.domain.account.AccountSocialAuthDomain;
import tiger.core.domain.attach.AttachDomain;
import tiger.core.service.account.AccountBindService;
import tiger.core.service.account.AccountService;
import tiger.core.service.attach.QiniuAttachService;
import tiger.core.service.system.SystemParamService;
import tiger.core.social.auth.SocialAuthFactory;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author yiliang.gyl
 * @version $ID: v 0.1 5:28 PM yiliang.gyl Exp $
 */
@Service
public class SocialAccountManagerImpl implements SocialAccountManager {

    private static Logger logger = Logger.getLogger(SocialAccountManagerImpl.class);

    @Autowired
    SystemParamService systemParamService;

    @Autowired
    AccountBindService accountBindService;

    @Autowired
    AccountService accountService;


    @Autowired
    QiniuAttachService qiniuAttachService;

    @Autowired
    AccountManager accountManager;


    /**
     * @see SocialAccountManager#getSocialRedirectUrl(AccountSocialTypeEnum, String, String)
     */
    @Override
    public BaseResult<String> getSocialRedirectUrl(AccountSocialTypeEnum socialType, String bindType, String ipAddress) {
        //1. 把Type编辑到state状态码中
        String state = new StringBuffer(socialType.getCode()).
                append("_").
                append(bindType).
                append("-").
                append(UUID.randomUUID().toString()).toString();
        return new BaseResult<>(getSocialFactory(socialType).getRedirectUrl(state));
    }

    /**
     * @see SocialAccountManager#bindSocialAccount(Long, AccountSocialTypeEnum, String, String)
     */
    @Override
    public BaseResult<AccountBindDomain> bindSocialAccount(Long accountId, AccountSocialTypeEnum socialType, String code, String state) {

        //1. 通过code 和 state 获取社交账户信息
        AccountBindDomain bindDomain = getSocialFactory(socialType).getAuthUserInfo(code, state);

        if (bindDomain == null) {
            throw new TigerException(ErrorCodeEnum.AUTHORIZE_FAIL, "授权失败,无法获取第三方信息");
        }

        AccountBindDomain accountBindDomain = accountBindService.findAccountByOpenId(bindDomain.getOpenId(), socialType);

        //2. 查看该第三方账户是否有绑定其他帐号
        if (accountBindDomain != null) {
            if (accountBindDomain.getAccountId().equals(accountId)) {
                throw new TigerException(ErrorCodeEnum.BIZ_DUPLICATIVE, "您已经绑定过了，无需重复绑定");
            } else {
                throw new TigerException(ErrorCodeEnum.BIZ_DUPLICATIVE, "改帐号已经绑定了其他账户!");
            }
        } else {
            //3.开始绑定当前账户
            List<AccountSocialTypeEnum> types = new ArrayList<>();
            if (socialType == AccountSocialTypeEnum.QQ || socialType == AccountSocialTypeEnum.QQMOBILE) {
                types.add(AccountSocialTypeEnum.QQ);
                types.add(AccountSocialTypeEnum.QQMOBILE);
            } else if (socialType == AccountSocialTypeEnum.WECHAT || socialType == AccountSocialTypeEnum.WECHATMOBILE) {
                types.add(AccountSocialTypeEnum.WECHAT);
                types.add(AccountSocialTypeEnum.WECHATMOBILE);
            }
            if (CollectionUtils.isEmpty(types)) {
                throw new TigerException(ErrorCodeEnum.ILLEGAL_PARAMETER_VALUE, "不支持的第三方账户绑定类型");
            }

            //3.1 判断该账号是否已经有了对应的绑定
            int existBind = accountBindService.readByAccountAndType(accountId, types).size();
            if (existBind > 0) {
                throw new TigerException(ErrorCodeEnum.BIZ_DUPLICATIVE, "该账户已经有绑定了,无需重新绑定");
            }
            //3.2 绑定
            bindDomain.setAccountId(accountId);
            bindDomain.setAccountType(socialType);
            bindDomain = accountBindService.bindSocialAccount(bindDomain);
            if (bindDomain == null) {
                throw new TigerException(ErrorCodeEnum.BIZ_FAIL, "绑定帐号失败，数据库错误");
            } else {
                return new BaseResult<>(bindDomain);
            }
        }
    }

    /**
     * @see SocialAccountManager#getAccountSocialBinds(Long)
     */
    @Override
    public BaseResult<List<AccountBindDomain>> getAccountSocialBinds(Long accountId) {
        return new BaseResult<>(accountBindService.readByAccount(accountId));
    }

    /**
     * @see SocialAccountManager#deleteBindSocial(Long, Long)
     */
    @Override
    public BaseResult<Boolean> deleteBindSocial(Long accountId, Long bindId) {
        AccountBindDomain bindDomain = accountBindService.read(bindId);
        if (bindDomain == null) {
            throw new TigerException(ErrorCodeEnum.NOT_FOUND, "没有找到要查找的对象");
        }
        if (!bindDomain.getAccountId().equals(accountId)) {
            throw new TigerException(ErrorCodeEnum.UNAUTHORIZED, "您不能操作不属于你的绑定信息");
        }
        return new BaseResult<>(accountBindService.delete(bindId));
    }

    /**
     * @see SocialAccountManager#authSocialAccountByToken(AccountSocialTypeEnum, String, String)
     */
    @Override
    @Transactional
    public AccountSocialAuthDomain authSocialAccountByToken(AccountSocialTypeEnum socialType,
                                                            String token, String openId) {
        //1. 通过code 和 state 获取社交账户信息
        AccountBindDomain bindDomain = getSocialFactory(socialType).getAuthUserInfo(token, openId);

        if (bindDomain == null) {
            throw new TigerException(ErrorCodeEnum.AUTHORIZE_FAIL, "授权失败,无法获取第三方信息");
        }

        return authSocialByBindDomain(bindDomain, socialType);
    }


    /**
     * @see SocialAccountManager#authSocialAccount(AccountSocialTypeEnum, String, String, String)
     */
    @Override
    @Transactional
    public AccountSocialAuthDomain authSocialAccount(AccountSocialTypeEnum socialType,
                                                     String code, String state, String ipAddress) {

        //1. 通过code 和 state 获取社交账户信息
        AccountBindDomain bindDomain = getSocialFactory(socialType).getAuthUserInfo(code, state);

        if (bindDomain == null) {
            throw new TigerException(ErrorCodeEnum.AUTHORIZE_FAIL, "授权失败,无法获取第三方信息");
        }

        return authSocialByBindDomain(bindDomain, socialType);
    }


    /**
     * @see SocialAccountManager#changeAccountSocialBind(Long, Long)
     */
    @Override
    @Transactional
    public AccountBindDomain changeAccountSocialBind(Long accountBindId, Long accountId) {
        AccountBindDomain accountBindDomain = accountBindService.read(accountBindId);
        Long oldAccountId = accountBindDomain.getAccountId();
        if (accountBindDomain == null) {
            throw new TigerException(ErrorCodeEnum.NOT_FOUND, "不存在的社交账户");
        }
        if (oldAccountId != null && oldAccountId.equals(accountId)) {
            return accountBindDomain;
        }
        if (accountBindService.changeBindObject(accountBindDomain.getId(), accountId)) {
            accountBindDomain.setAccountId(accountId);
            //删除原账户绑定
            if (oldAccountId != null) {
                if (accountService.delete(oldAccountId)) {
                    if (logger.isInfoEnabled()) {
                        logger.info("删除冗余账户信息[" + oldAccountId + "] 成功，原社交账户 bindId:[" + accountBindId + "]");
                    }
                } else {
                    logger.error("删除冗余账户信息[" + oldAccountId + "] 失败，原社交账户 bindId:[" + accountBindId + "]");
                }
            }
            return accountBindDomain;
        } else {
            throw new TigerException(ErrorCodeEnum.BIZ_FAIL, "绑定账户失败");
        }
    }

    /**
     * @see SocialAccountManager#loginByBindId(Long)
     */
    @Override
    @Transactional
    public AccountDomain loginByBindId(Long bindId) {
        //1. 更新一下社交账户的绑定嘻嘻你，注册一个账户
        AccountBindDomain accountBindDomain = accountBindService.read(bindId);
        if (accountBindDomain == null) {
            throw new TigerException(ErrorCodeEnum.NOT_FOUND, "不存在的绑定");
        }
        //2. 返回用户信息
        if (accountBindDomain.getAccountId() == null || !accountBindDomain.getHasBind()) {
            AccountDomain accountDomain = createAccountAndBindSocial(accountBindDomain);
            if (accountDomain == null) {
                throw new TigerException(ErrorCodeEnum.BIZ_FAIL, "不存在的绑定");
            }
            return accountDomain;
        } else {
            return accountService.read(accountBindDomain.getAccountId());
        }
    }

    //~ private methods

    private AccountSocialAuthDomain authSocialByBindDomain(AccountBindDomain bindDomain, AccountSocialTypeEnum socialType) {

        AccountSocialAuthDomain resultDomain = new AccountSocialAuthDomain();

        //2. 查看是否有已经授权绑定的客户
        AccountBindDomain accountBindDomain = accountBindService.findAccountByOpenId(bindDomain.getOpenId(), socialType);
        if (accountBindDomain != null && accountBindDomain.getHasBind()) {
            //2.1 直接登录
            AccountDomain account = accountService.read(accountBindDomain.getAccountId());
            resultDomain.setCanBindAccount(false);
            //2.2 设置用户头像和公司信息
            // 设置头像信息
            AttachDomain attachDomain = account.getIcon();
            if (null != attachDomain) {
                if (AttachTypeEnum.PUBLIC.equals(attachDomain.getAttachType()) && FileUtil.isImageFileFromName(attachDomain.getName())) {
                    account.setIcon(qiniuAttachService.getAttachWithSignedUrlById(attachDomain.getId()));
                } else {
                    logger.error("用户[ " + account + " ]头像设置错误");
                }
            }
            // 设置公司信息
            if (!accountManager.hasBindMobile(account.getId())) {
                account.setMobile(null);
            }
            resultDomain.setAccount(account);
            resultDomain.setAccountBind(accountBindDomain);
        } else if (accountBindDomain != null) {
            //3. 添加绑定信息到数据库
            resultDomain.setCanBindAccount(true);
            resultDomain.setAccountBind(accountBindDomain);
        } else {
            //2.3 新建绑定用户
            resultDomain = createNewBindAndUser(bindDomain, socialType);
        }
        return resultDomain;
    }

    /**
     * 新建绑定用户
     *
     * @param bindDomain
     * @param socialType
     * @return
     */
    private AccountSocialAuthDomain createNewBindAndUser(AccountBindDomain bindDomain, AccountSocialTypeEnum socialType) {
        AccountSocialAuthDomain resultDomain = new AccountSocialAuthDomain();
        //3. 添加绑定信息到数据库
        bindDomain.setAccountType(socialType);
        bindDomain.setHasBind(false);
        bindDomain = accountBindService.bindSocialAccount(bindDomain);
        resultDomain.setCanBindAccount(true);
        resultDomain.setAccountBind(bindDomain);
        return resultDomain;
    }

    /**
     * 通过 bindDomain 新建
     *
     * @param bindDomain
     * @return
     */
    private AccountDomain createAccountAndBindSocial(AccountBindDomain bindDomain) {
        //1. 创建一个新客户,不登陆直接返回
        AccountDomain accountDomain = new AccountDomain();
        accountDomain.setUserName(bindDomain.getAccountName());
        accountDomain.setMobile(bindDomain.getOpenId().substring(0, 13));

        //2. 添加空的公司信息
        accountDomain = accountService.addAccount(accountDomain);
        if (accountDomain != null) {
            //更新绑定的状态为已绑定
            AccountBindDomain updateBind = new AccountBindDomain();
            updateBind.setId(bindDomain.getId());
            updateBind.setHasBind(true);
            updateBind.setAccountId(accountDomain.getId());
            if (accountBindService.updateBind(updateBind)) {
                return accountDomain;
            } else {
                throw new TigerException(ErrorCodeEnum.BIZ_FAIL);
            }

        } else {
            throw new TigerException(ErrorCodeEnum.BIZ_FAIL, "服务异常.");
        }
    }

    /**
     * 获取相关第三方授权的工厂类
     *
     * @param socialType
     * @return
     */
    private SocialAuthFactory getSocialFactory(AccountSocialTypeEnum socialType) {
        if (socialType == null) {
            throw new TigerException(ErrorCodeEnum.ILLEGAL_PARAMETER_VALUE, "所选业务不被系统支持");
        }
        String appId = systemParamService.getValueByTypeAndKey(SystemParamTypeEnum.SOCIAL_ACCOUNT_APP_ID,
                socialType.getCode());
        String secret = systemParamService.getValueByTypeAndKey(SystemParamTypeEnum.SOCIAL_ACCOUNT_TOKEN,
                socialType.getCode());
        String redirectUrl = systemParamService.getValueByTypeAndKey(SystemParamTypeEnum.SOCIAL_ACCOUNT_AUTH_URL,
                socialType.getCode());
        if (StringUtil.isBlank(appId) || StringUtil.isBlank(secret) || StringUtil.isBlank(redirectUrl)) {
            throw new TigerException(ErrorCodeEnum.BIZ_FAIL, "当前系统未开发该功能");
        }
        return new SocialAuthFactory(appId, secret, redirectUrl, socialType);
    }

}
