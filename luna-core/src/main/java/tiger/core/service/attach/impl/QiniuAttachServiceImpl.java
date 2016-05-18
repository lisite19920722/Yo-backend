/**
 * 404 Team
 * Copyright (c) 2014-2015 All Rights Reserved.
 */
package tiger.core.service.attach.impl;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.common.dal.enums.AttachTypeEnum;
import tiger.common.dal.persistence.attach.AttachDO;
import tiger.common.dal.persistence.attach.example.AttachExample;
import tiger.common.dal.persistence.mapper.AttachMapper;
import tiger.common.dal.persistence.attach.query.AttachQuery;
import tiger.common.util.ByteUtil;
import tiger.common.util.FileUtil;
import tiger.common.util.JsonConverterUtil;
import tiger.common.util.StringUtil;
import tiger.common.util.component.qiniu.QiniuUtil;
import tiger.core.basic.constants.SystemConstants;
import tiger.core.basic.enums.ErrorCodeEnum;
import tiger.core.basic.exception.TigerException;
import tiger.core.basic.util.QiniuConfigFacotry;
import tiger.core.domain.attach.AttachDomain;
import tiger.core.domain.attach.QiniuUploadDomain;
import tiger.core.domain.attach.convert.AttachConverter;
import tiger.core.service.attach.AttachService;
import tiger.core.service.attach.QiniuAttachService;
import tiger.core.service.system.SystemParamService;

import java.util.*;

/**
 * @author alfred.yx
 * @version v 0.1 Oct 3, 2015 11:48:36 PM alfred Exp $
 */
@Service
public class QiniuAttachServiceImpl implements QiniuAttachService {
    private final Logger logger = Logger.getLogger(QiniuAttachServiceImpl.class);
    private final Base64.Encoder BASE64_ENCODER = Base64.getUrlEncoder();
    private final Base64.Decoder BASE64_DECODER = Base64.getUrlDecoder();
    private final String CALLBACK_TEMPLATE = "url=%s&name=%s&size=$(fsize)&attachType=%s&metaData=%s&accountId=%d";

    @Autowired
    private AttachMapper attachMapper;

    @Autowired
    private SystemParamService systemParamService;

    /**
     * @see QiniuAttachService#getAttachWithSignedUrlById(Long)
     */
    @Override
    public AttachDomain getAttachWithSignedUrlById(Long attachId) {
        if (attachId == null) {
            return null;
        }

        AttachDomain qiniuAttach = read(attachId);

        return getAttachWithSignedUrl(qiniuAttach);
    }

    /**
     * @see QiniuAttachService#getAttachWithSignedUrl(AttachDomain)
     */
    @Override
    public AttachDomain getAttachWithSignedUrl(AttachDomain qiniuAttach) {
        if (null == qiniuAttach) {
            return null;
        }
        // 设置七牛signed url, 默认时长3600s
        qiniuAttach.setUrl(QiniuConfigFacotry
                .createQiniuConfig(qiniuAttach.getAttachType(), systemParamService).getSignedUrl(qiniuAttach.getUrl()));

        return qiniuAttach;
    }

    /**
     * @see QiniuAttachService#getAttachesWithSignedUrlByIds(List)
     */
    @Override
    public List<AttachDomain> getAttachesWithSignedUrlByIds(List<Long> attachIds) {
        if (CollectionUtils.isEmpty(attachIds)) {
            return new ArrayList<>();
        }

        AttachQuery attachQuery = new AttachQuery();
        attachQuery.setIds(attachIds);

        return getAttachesWithSignedUrl(query(attachQuery));
    }

    /**
     * @see QiniuAttachService#getAttachesWithSignedUrl(List)
     */
    @Override
    public List<AttachDomain> getAttachesWithSignedUrl(List<AttachDomain> qiniuAttaches) {
        if (CollectionUtils.isEmpty(qiniuAttaches)) {
            return qiniuAttaches;
        }

        HashMap<AttachTypeEnum, QiniuUtil> qiniuUtilHashMap = new HashMap<>();
        qiniuAttaches.forEach(qiniuAttach -> {
            // 设置七牛云的Util
            if (!qiniuUtilHashMap.containsKey(qiniuAttach.getAttachType())) {
                qiniuUtilHashMap.put(qiniuAttach.getAttachType(),
                        QiniuConfigFacotry.createQiniuConfig(qiniuAttach.getAttachType(), systemParamService));
            }
            // 设置七牛signed url, 默认时长3600s
            qiniuAttach.setUrl(qiniuUtilHashMap.get(qiniuAttach.getAttachType()).getSignedUrl(qiniuAttach.getUrl()));
        });

        return qiniuAttaches;
    }

    /**
     * @see QiniuAttachService#getQiniuUploadToken(AttachDomain, Long)
     */
    @Override
    public QiniuUploadDomain getQiniuUploadToken(AttachDomain attachDomain,
                                                 Long accountId) {
        if (attachDomain == null || accountId == null) {
            return null;
        }

        // 1. 先检查唯一性
        String orginFileName = attachDomain.getName();

        // 2. 校验文件名长度
        if (orginFileName.length() > SystemConstants.MAX_FILENAME_LENGTH) {
            throw new TigerException(ErrorCodeEnum.LENGTH_OVER_MAX_LIMITED);
        }

        // 3. 校验文件名是否为 文件名.文件类型 格式
        if (0 >= orginFileName.lastIndexOf(".")) {
            throw new TigerException(ErrorCodeEnum.ILLEGAL_PARAMETER_VALUE);
        }
        String randomFilename = FileUtil.generateRandomFileName(attachDomain.getName(), accountId);
        if (isFilenameExist(randomFilename)) {
            throw new TigerException(ErrorCodeEnum.ILLEGAL_PARAMETER_VALUE, "该附件名已存在");
        }

        // 4. 生成七牛callbackBody
        String callbackBody = getCallbackBody(randomFilename, attachDomain, accountId);

        // 5. 设置返回domain
        QiniuUploadDomain uploadToken = new QiniuUploadDomain();
        uploadToken.setKey(randomFilename);
        uploadToken.setToken(QiniuConfigFacotry
                .createQiniuConfig(attachDomain.getAttachType(), systemParamService).getCallbackUpToken(callbackBody));

        return uploadToken;
    }

    /**
     * @see AttachService#deleteAttachById(Long)
     */
    @Override
    public boolean deleteAttachById(Long attachId) {
        if (attachId == null) {
            return true;
        }

        AttachDomain attachDomain = read(attachId);
        if (null == attachDomain) {
            // 如果attachId不存在这返回true
            return true;
        }
        // 1. 先删除附件及其关系
        attachMapper.deleteAttachById(attachId);
        // 2. 删除七牛云文件
        if (logger.isInfoEnabled()) {
            logger.info("删除七牛云文件， id: " + attachId + "， key: " + attachDomain.getUrl());
        }
        return QiniuConfigFacotry.createQiniuConfig(attachDomain.getAttachType(), systemParamService)
                .deleteFile(attachDomain.getUrl());
    }

    /**
     * @see AttachService#isAllExist(List)
     */
    @Override
    public boolean isAllExist(List<Long> attachIds) {
        if (CollectionUtils.isEmpty(attachIds)) {
            return true;
        }
        return attachIds.size() == attachMapper.countExistedIds(attachIds, null, null);
    }

    /**
     * @see QiniuAttachService#isExist(Long)
     */
    @Override
    public boolean isExist(Long attachId) {
        return null != read(attachId);
    }

    /**
     * @see QiniuAttachService#read(Long)
     */
    @Override
    public AttachDomain read(Long id) {
        if (id == null) {
            return null;
        }

        AttachDO attachDO = attachMapper.selectByPrimaryKey(id);
        return AttachConverter.convert2Domain(attachDO);
    }

    /**
     * @see QiniuAttachService#qiniuCallback(AttachDomain, String, String, String)
     */
    @Override
    public AttachDomain qiniuCallback(AttachDomain attachDomain,
                                      String originAuthorization,
                                      String callbackBody,
                                      String callbackContentType) {
        attachDomain = setCallbackBody(attachDomain);

        // 验证是否为合法的callback
        if (!QiniuConfigFacotry.createQiniuConfig(attachDomain.getAttachType(), systemParamService)
                .isValidCallback(originAuthorization, callbackBody, callbackContentType)) {
            throw new TigerException(ErrorCodeEnum.ILLEGAL_PARAMETER);
        }

        // 如果已经存在则认为token已经被使用,返回错误
        if (isFilenameExist(attachDomain.getUrl())) {
            throw new TigerException(ErrorCodeEnum.BIZ_EXPIRED);
        }

        return create(attachDomain);
    }

    /**
     * @see QiniuAttachService#isOwner(Long, Long)
     */
    @Override
    public boolean isOwner(Long attachId, Long accountId) {
        AttachDomain attachDomain = read(attachId);
        // 如果attach的accountId与参数accountId不符,则返回false
        if (null == attachDomain || !attachDomain.getAccountId().equals(accountId)) {
            return false;
        }

        return true;
    }

    /**
     * @see QiniuAttachService#isOwnerOfAll(List, Long)
     */
    @Override
    public boolean isOwnerOfAll(List<Long> attachIds, Long accountId) {
        if (CollectionUtils.isEmpty(attachIds) || accountId == null) {
            return true;
        }
        return attachIds.size() == attachMapper.countExistedIds(attachIds, accountId, null);
    }

    /**
     * @see QiniuAttachService#isAttachType(Long, AttachTypeEnum)
     */
    @Override
    public boolean isAttachType(Long attachId, AttachTypeEnum attachType) {
        AttachDomain attachDomain = read(attachId);
        if (attachDomain != null && attachType.equals(attachDomain.getAttachType())) {
            return true;
        }
        return false;
    }

    /**
     * @see QiniuAttachService#isAllAttachType(List, AttachTypeEnum)
     */
    @Override
    public boolean isAllAttachType(List<Long> attachIds, AttachTypeEnum attachType) {
        if (CollectionUtils.isEmpty(attachIds) || attachType == null) {
            return true;
        }

        return attachIds.size() == attachMapper.countExistedIds(attachIds, null, attachType.getCode());
    }

    /**
     * @see QiniuAttachService#isFilenameExist(String)
     */
    @Override
    public boolean isFilenameExist(String fileName) {
        if (StringUtil.isBlank(fileName)) {
            return true;
        }

        return attachMapper.countByUrl(fileName) > 0;
    }

    /**
     * @see QiniuAttachService#create(AttachDomain)
     */
    @Override
    public AttachDomain create(AttachDomain attachDomain) {
        if (attachDomain == null) {
            return null;
        }

        AttachDO attachDo = AttachConverter.convert2DO(attachDomain);
        int insertResult = attachMapper.insertSelective(attachDo);
        if (insertResult > 0) {
            return AttachConverter.convert2Domain(attachDo);
        }

        throw new TigerException(ErrorCodeEnum.DB_EXCEPTION);
    }

    /**
     * @see AttachService#query(AttachQuery)
     */
    @Override
    public List<AttachDomain> query(AttachQuery query) {
        if (query == null || CollectionUtils.isEmpty(query.getIds())) {
            return new ArrayList<>();
        }

        AttachExample example = new AttachExample();
        AttachExample.Criteria exampleCriteria = example.createCriteria();

        exampleCriteria.andIdIn(query.getIds());
        exampleCriteria.andIsDelEqualTo(ByteUtil.BYTE_ZERO);

        return AttachConverter.convert2Domains(attachMapper.selectByExample(example));
    }

    // ~ Private Method

    /**
     * 生成七牛云的回调callBody
     * 并对参数进行base 64转义
     *
     * @param randomFilename
     * @param attachDomain
     * @param accountId
     * @return
     */
    private String getCallbackBody(String randomFilename, AttachDomain attachDomain,
                                   Long accountId) {
        HashMap<String, String> encodedMap = new HashMap<>();

        for (Map.Entry<String, String> entry : attachDomain.getMetaData().entrySet()) {
            encodedMap.put(
                    BASE64_ENCODER.encodeToString(entry.getKey().getBytes()),
                    BASE64_ENCODER.encodeToString(entry.getValue().getBytes())
            );
        }

        String callBackBody = String.format(
                CALLBACK_TEMPLATE,
                BASE64_ENCODER.encodeToString(randomFilename.getBytes()),
                BASE64_ENCODER.encodeToString(attachDomain.getName().getBytes()),
                attachDomain.getAttachType(),
                JsonConverterUtil.serialize(encodedMap),
                accountId
        );

        return callBackBody;
    }

    /**
     * 将getCallbackBody中转义的参数，进行反转义
     *
     * @param attachDomain
     * @return
     */
    private AttachDomain setCallbackBody(AttachDomain attachDomain) {
        HashMap<String, String> decodedMap = new HashMap<>();

        for (Map.Entry<String, String> entry : attachDomain.getMetaData().entrySet()) {
            decodedMap.put(
                    new String(BASE64_DECODER.decode(entry.getKey())),
                    new String(BASE64_DECODER.decode(entry.getValue()))
            );
        }

        attachDomain.setUrl(new String(BASE64_DECODER.decode(attachDomain.getUrl())));
        attachDomain.setName(new String(BASE64_DECODER.decode(attachDomain.getName())));
        attachDomain.setMetaData(decodedMap);

        return attachDomain;
    }
}
