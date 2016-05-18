/**
 * 404 Studio Inc.
 * Copyright (c) 2014-2015 All Rights Reserved.
 */
package tiger.biz.system.support;


import tiger.core.basic.BaseResult;
import tiger.core.domain.system.FeedbackDomain;

/**
 * @author alfred_yuan
 * @version v 0.1 20:26 alfred_yuan Exp $
 */
public interface FeedbackManager {

    /**
     * 创建一个反馈
     * @param feedbackDomain
     * @return
     */
    BaseResult<FeedbackDomain> createFeedback(FeedbackDomain feedbackDomain);
}
