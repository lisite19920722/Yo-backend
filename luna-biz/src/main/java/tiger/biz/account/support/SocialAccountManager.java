/**
 * 404 Studio Inc.
 * Copyright (c) 2014-2015 All Rights Reserved.
 */
package tiger.biz.account.support;

import tiger.common.dal.enums.AccountSocialTypeEnum;
import tiger.core.basic.BaseResult;
import tiger.core.domain.account.AccountBindDomain;
import tiger.core.domain.account.AccountDomain;
import tiger.core.domain.account.AccountSocialAuthDomain;

import java.util.List;

/**
 * 第三方账号服务
 *
 * @author yiliang.gyl
 * @version $ID: v 0.1 5:27 PM yiliang.gyl Exp $
 */
public interface SocialAccountManager {

    /**
     * 获取第三方账号认证的跳转地址
     *
     * @param socialType
     * @param ipAddress
     * @return
     */
    BaseResult<String> getSocialRedirectUrl(AccountSocialTypeEnum socialType, String bindType, String ipAddress);

    /**
     * 绑定第三方账户
     *
     * @param socialType
     * @param code
     * @param state
     * @return
     */
    BaseResult<AccountBindDomain> bindSocialAccount(Long accountId, AccountSocialTypeEnum socialType, String code, String state);

    /**
     * 获取用户绑定的所有第三方账户
     *
     * @param accountId
     * @return
     */
    BaseResult<List<AccountBindDomain>> getAccountSocialBinds(Long accountId);

    /**
     * 解除绑定
     *
     * @param accountId
     * @param bindId
     * @return
     */
    BaseResult<Boolean> deleteBindSocial(Long accountId, Long bindId);


    /**
     *
     * @param socialType
     * @param token
     * @param openId
     * @return
     */
    AccountSocialAuthDomain authSocialAccountByToken(AccountSocialTypeEnum socialType,
                                                     String token, String openId);

    /**
     * 通过第三方账户进行认证业务
     *
     * @param code
     * @param state
     * @param ipAddress
     * @return
     */
    AccountSocialAuthDomain authSocialAccount(AccountSocialTypeEnum socialType, String code, String state, String ipAddress);


    /**
     * 更换社交账户绑定主体
     *
     * @param accountBindId
     * @param accountId
     * @return
     */
    AccountBindDomain changeAccountSocialBind(Long accountBindId, Long accountId);


    /**
     * 通过bindId 登录
     *
     * @param bindId
     * @return
     */
    AccountDomain loginByBindId(Long bindId);

}
