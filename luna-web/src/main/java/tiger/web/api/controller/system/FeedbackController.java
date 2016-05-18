/**
 * 404 Studio Inc.
 * Copyright (c) 2014-2015 All Rights Reserved.
 */
package tiger.web.api.controller.system;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tiger.biz.system.support.FeedbackManager;
import tiger.common.dal.annotation.LoginRequired;
import tiger.core.basic.BaseResult;
import tiger.core.domain.account.AccountDomain;
import tiger.core.domain.system.FeedbackDomain;
import tiger.web.api.constants.APIConstants;
import tiger.web.api.controller.BaseController;
import tiger.web.api.form.system.FeedbackCreateForm;

import javax.validation.Valid;

/**
 * 用户反馈接口
 *
 * @author alfred_yuan
 * @version v 0.1 16:18 alfred_yuan Exp $
 */
@RestController
@RequestMapping(value = APIConstants.BASE_API_URL)
public class FeedbackController extends BaseController {
    Logger logger = Logger.getLogger(FeedbackController.class);

    @Autowired
    FeedbackManager feedbackManager;

    /**
     * 提交反馈接口
     *
     * @param form
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/feedback", method = RequestMethod.POST)
    @LoginRequired
    public BaseResult<FeedbackDomain> createFeedback(@RequestBody @Valid FeedbackCreateForm form,
                                                     BindingResult bindingResult) {
        AccountDomain currentAccount = currentAccount();
        if (logger.isInfoEnabled()) {
            logger.info("[" + currentAccount.getId() + "] 创建反馈, 参数为 [" + form + "]");
        }
        FeedbackDomain feedbackDomain = form.convert2Domain();
        feedbackDomain.setAccountId(currentAccount.getId());

        return feedbackManager.createFeedback(feedbackDomain);
    }
}
