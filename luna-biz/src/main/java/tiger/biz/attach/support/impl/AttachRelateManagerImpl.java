/**
 * 404 Studio Inc.
 * Copyright (c) 2014-2015 All Rights Reserved.
 */
package tiger.biz.attach.support.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.biz.attach.support.AttachRelateManager;
import tiger.common.dal.enums.AttachTypeEnum;
import tiger.common.dal.persistence.attach.query.AttachRelateQuery;
import tiger.core.basic.BaseResult;
import tiger.core.basic.enums.ErrorCodeEnum;
import tiger.core.domain.attach.AttachDomain;
import tiger.core.domain.attach.AttachRelateDomain;
import tiger.core.service.attach.AttachRelateService;
import tiger.core.service.attach.QiniuAttachService;

import java.util.List;


/**
 * @author yiliang.gyl
 * @version $ID: v 0.1 2:26 PM yiliang.gyl Exp $
 */
@Service
public class AttachRelateManagerImpl implements AttachRelateManager {

    @Autowired
    private AttachRelateService attachRelateService;

    @Autowired
    private QiniuAttachService qiniuAttachService;

    /**
     * @see AttachRelateManager#relateAttach(AttachRelateDomain, Long)
     */
    @Override
    public BaseResult<Boolean> relateAttach(AttachRelateDomain attachRelateDomain, Long accountId) {
        if (attachRelateDomain == null || attachRelateDomain.getAttachId() == null || accountId == null) {
            return new BaseResult<>(true);
        }

        AttachDomain attach = qiniuAttachService.read(attachRelateDomain.getAttachId());
        // 检查附件是否存在
        if (attach == null) {
            return new BaseResult<>(ErrorCodeEnum.NOT_FOUND, false);
        }
        // 检查附件是否为当前用户所有
        if (!attach.getAccountId().equals(accountId)) {
            return new BaseResult<>(ErrorCodeEnum.UNAUTHORIZED, false);
        }
        // 检查附件是否为私有附件
        if (!attach.getAttachType().equals(AttachTypeEnum.SECRET)) {
            return new BaseResult<>(ErrorCodeEnum.ILLEGAL_PARAMETER, false);
        }
        // 检查当前关联是否已经存在
        if (attachRelateService.isExist(attachRelateDomain)) {
            return new BaseResult<>(ErrorCodeEnum.BIZ_DUPLICATIVE);
        }
        // 关联附件
        if (attachRelateService.relateAttach(attachRelateDomain)) {
            return new BaseResult<>(true);
        }

        return new BaseResult<>(ErrorCodeEnum.BIZ_FAIL, false);
    }

    /**
     * @see AttachRelateManager#deRelateAttach(AttachRelateDomain)
     */
    @Override
    public BaseResult<Boolean> deRelateAttach(AttachRelateDomain attachRelateDomain) {
        if (attachRelateDomain == null) {
            return new BaseResult<>(true);
        }

        boolean result = attachRelateService.deRelateAttachById(attachRelateDomain);
        if (result) {
            return new BaseResult<>(true);
        } else {
            return new BaseResult<>(ErrorCodeEnum.BIZ_FAIL, false);
        }
    }

    /**
     * @see AttachRelateManager#listAttachs(AttachRelateDomain)
     */
    @Override
    public BaseResult<List<AttachDomain>> listAttachs(AttachRelateDomain attachRelateDomain) {
        AttachRelateQuery query = new AttachRelateQuery();
        query.setSubjectId(attachRelateDomain.getSubjectId());
        query.setBizTypeEnum(attachRelateDomain.getBizType());
        return new BaseResult<>(
                qiniuAttachService.getAttachesWithSignedUrl(
                        attachRelateService.listAttaches(query)
                )
        );
    }
}
