/**
 * 404 Studio Inc.
 * Copyright (c) 2014-2015 All Rights Reserved.
 */
package tiger.biz.system.support.impl;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tiger.biz.system.support.FeedbackManager;
import tiger.common.dal.enums.AttachBizTypeEnum;
import tiger.common.dal.enums.AttachTypeEnum;
import tiger.core.basic.BaseResult;
import tiger.core.basic.enums.ErrorCodeEnum;
import tiger.core.basic.exception.TigerException;
import tiger.core.domain.attach.AttachRelateDomain;
import tiger.core.domain.system.FeedbackDomain;
import tiger.core.service.attach.AttachRelateService;
import tiger.core.service.attach.QiniuAttachService;
import tiger.core.service.system.FeedbackService;


import java.util.ArrayList;
import java.util.List;

/**
 * @author alfred_yuan
 * @version v 0.1 20:32 alfred_yuan Exp $
 */
@Service
public class FeedbackManagerImpl implements FeedbackManager {

    Logger logger = Logger.getLogger(FeedbackManagerImpl.class);

    @Autowired
    FeedbackService feedbackService;

    @Autowired
    QiniuAttachService qiniuAttachService;

    @Autowired
    AttachRelateService attachRelateService;

    @Override
    @Transactional
    public BaseResult<FeedbackDomain> createFeedback(FeedbackDomain feedbackDomain) {

        Long accountId = feedbackDomain.getAccountId();
        if (logger.isInfoEnabled()) {
            logger.info("用户 [" + accountId + "] 创建Feedback，接受到的信息为 [" + feedbackDomain + "]");
        }

        // 1. 检查附件是否全部为account所有，并且为SECRET类型
        List<AttachRelateDomain> attachRelateDomains = feedbackDomain.getAttachRelateDomains();
        if (!CollectionUtils.isEmpty(attachRelateDomains)) {
            List<Long> attachIds = new ArrayList<>(attachRelateDomains.size());
            attachRelateDomains.forEach(attach -> attachIds.add(attach.getAttachId()));

            if (!qiniuAttachService.isOwnerOfAll(attachIds, accountId)
                    || !qiniuAttachService.isAllAttachType(attachIds, AttachTypeEnum.SECRET)) {
                logger.error("[" + accountId + "] 不是附件的所有者或附件不是SECRET类型，" +
                        "接受到的信息为 [" + feedbackDomain + "]");
                throw new TigerException(ErrorCodeEnum.ILLEGAL_PARAMETER, "附件必须全部为当前用户所有,且均为SECRET类型");
            }
        }

        // 2. 创建反馈
        FeedbackDomain resultDomain = feedbackService.create(feedbackDomain);
        if (null == resultDomain) {
            logger.error("创建Feedback失败，接受到的信息为 [" + feedbackDomain + "]");
            throw new TigerException(ErrorCodeEnum.BIZ_FAIL, "创建反馈信息失败");
        }

        // 3. 关联附件列表
        if (!CollectionUtils.isEmpty(attachRelateDomains)) {
            Long customerId = resultDomain.getId();
            attachRelateDomains.forEach(attachRelateDomain -> {
                attachRelateDomain.setSubjectId(customerId);
                attachRelateDomain.setBizType(AttachBizTypeEnum.FEEDBACK);
            });
            if (!attachRelateService.relateAttaches(attachRelateDomains)) {
                logger.error("关联反馈附件失败，接受到的信息为 [" + feedbackDomain + "]");
                throw new TigerException(ErrorCodeEnum.BIZ_FAIL, "关联反馈附件失败");
            }
        }

        return new BaseResult<>(resultDomain);
    }
}
