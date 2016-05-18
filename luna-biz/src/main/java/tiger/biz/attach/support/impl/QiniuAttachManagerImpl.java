/**
 * 404 Studio Inc.
 * Copyright (c) 2014-2015 All Rights Reserved.
 */
package tiger.biz.attach.support.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.biz.attach.support.AttachManager;
import tiger.core.basic.util.QiniuConfigFacotry;
import tiger.core.domain.attach.AttachDomain;
import tiger.core.domain.attach.QiniuUploadDomain;
import tiger.core.service.attach.QiniuAttachService;
import tiger.core.service.system.SystemParamService;

/**
 * @author alfred_yuan
 * @version v 0.1 17:22 alfred_yuan Exp $
 */
@Service
public class QiniuAttachManagerImpl implements AttachManager{

    Logger logger = Logger.getLogger(QiniuAttachManagerImpl.class);

    @Autowired
    QiniuAttachService attachService;

    @Autowired
    SystemParamService systemParamService;

    /**
     * @see AttachManager#previewAttach(Long, String)
     */
    @Override
    public AttachDomain previewAttach(Long attachId, String previewMethod) {

        AttachDomain attachDomain = attachService.read(attachId);

        if (logger.isInfoEnabled()) {
            logger.info("对 ["+ attachDomain + "] 进行 ["+ previewMethod + "] 的预览操作");
        }

        // 设置七牛signed url, 默认时长3600s
        attachDomain.setUrl(QiniuConfigFacotry
                .createQiniuConfig(attachDomain.getAttachType(), systemParamService).getSignedUrl(attachDomain.getUrl() + "?" + previewMethod));

        return attachDomain;
    }

    /**
     * @see AttachManager#isExist(Long)
     */
    @Override
    public Boolean isExist(Long attachId) {
        return attachService.isExist(attachId);
    }

    /**
     * @see AttachManager#isOwner(Long, Long)
     */
    @Override
    public Boolean isOwner(Long attachId, Long accountId) {
        return attachService.isOwner(attachId, accountId);
    }

    /**
     * @see AttachManager#deleteAttachById(Long)
     */
    @Override
    public Boolean deleteAttachById(Long attachId) {
        return attachService.deleteAttachById(attachId);
    }

    /**
     * @see AttachManager#getQiniuUploadToken(AttachDomain, Long)
     */
    @Override
    public QiniuUploadDomain getQiniuUploadToken(AttachDomain attachDomain, Long accountId) {
        return attachService.getQiniuUploadToken(attachDomain, accountId);
    }

    /**
     * @see AttachManager#qiniuCallback(AttachDomain, String, String, String)
     */
    @Override
    public AttachDomain qiniuCallback(AttachDomain attachDomain, String originAuthorization, String callbackBody, String callbackContentType) {
        return attachService.qiniuCallback(attachDomain, originAuthorization, callbackBody, callbackContentType);
    }

    /**
     * @see  AttachManager#getAttachWithSignedUrlById(Long)
     */
    @Override
    public AttachDomain getAttachWithSignedUrlById(Long attachId) {
        return attachService.getAttachWithSignedUrlById(attachId);
    }
}
