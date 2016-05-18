/**
 * 404 Studio Inc.
 * Copyright (c) 2014-2015 All Rights Reserved.
 */
package tiger.biz.attach.support;


import tiger.core.domain.attach.AttachDomain;
import tiger.core.domain.attach.QiniuUploadDomain;

/**
 * @author alfred_yuan
 * @version v 0.1 17:19 alfred_yuan Exp $
 */
public interface AttachManager {

    /**
     * 获取预览附件的访问方式
     * @param attachId
     * @param previewMethod
     * @return
     */
    AttachDomain previewAttach(Long attachId, String previewMethod);

    /**
     * 判断附件是否存在
     *
     * @param attachId
     * @return
     */
    Boolean isExist(Long attachId);

    /**
     * 判断是否是所有者
     *
     * @param attachId
     * @return
     */
    Boolean isOwner(Long attachId, Long accountId);


    /**
     * 删除附件
     *
     * @param attachId
     * @return
     */
    Boolean deleteAttachById(Long attachId);

    /**
     * 获取七牛上传token
     *
     * @param attachDomain
     * @param accountId
     * @return
     */
    QiniuUploadDomain getQiniuUploadToken(AttachDomain attachDomain, Long accountId);


    /**
     * 七牛的回调业务
     * @param attachDomain
     * @param originAuthorization
     * @param callbackBody
     * @param callbackContentType
     * @return
     */
    AttachDomain qiniuCallback(AttachDomain attachDomain, String originAuthorization, String callbackBody, String callbackContentType);

    /**
     * 根据附件id获取附件,授权url
     *
     * @param attachId
     * @return
     */
    AttachDomain getAttachWithSignedUrlById(Long attachId);
}
