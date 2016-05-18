/**
 * 404 Team
 * Copyright (c) 2014-2015 All Rights Reserved.
 */
package tiger.core.service.attach;

import tiger.common.dal.enums.AttachTypeEnum;
import tiger.common.dal.persistence.attach.query.AttachQuery;
import tiger.core.domain.attach.AttachDomain;

import java.util.List;

/**
 * 附件Service
 *
 * @author alfred.yx
 * @version v 0.1 Oct 3, 2015 11:26:28 PM alfred Exp $
 */
public interface AttachService {


    /**
     * 根据附件id删除该附件
     *
     * @param attachId
     * @return Boolean
     */
    boolean deleteAttachById(Long attachId);

    /**
     * 判断抵押物ids是否都存在
     *
     * @param attachIds
     * @return
     */
    boolean isAllExist(List<Long> attachIds);

    /**
     * 判断抵押物id是否存在
     *
     * @param id
     * @return
     */
    boolean isExist(Long id);

    /**
     * 通过id获取附件模型
     *
     * @param id
     * @return
     */
    AttachDomain read(Long id);

    /**
     * 检查附件attachId是否为accountId所有
     *
     * @param attachId
     * @param accountId
     */
    boolean isOwner(Long attachId, Long accountId);

    /**
     * 检查附件attachIds是否都为accountId所有
     *
     * @param attachIds
     * @param accountId
     */
    boolean isOwnerOfAll(List<Long> attachIds, Long accountId);

    /**
     * 判断附件attachId是否为对应的attachtype
     *
     * @param attachId
     * @param attachType
     * @return
     */
    boolean isAttachType(Long attachId, AttachTypeEnum attachType);

    /**
     * 判断附件attachIds是否为对应的attachtype
     *
     * @param attachIds
     * @param attachType
     * @return
     */
    boolean isAllAttachType(List<Long> attachIds, AttachTypeEnum attachType);

    /**
     * 检查fileName是否已经存在
     *
     * @param fileName
     * @return
     */
    boolean isFilenameExist(String fileName);

    /**
     * 创建一个新的attach
     *
     * @param attachDomain
     * @return
     */
    AttachDomain create(AttachDomain attachDomain);

    /**
     * 查询附件信息
     *
     * @param query
     * @return
     */
    List<AttachDomain> query(AttachQuery query);
}
