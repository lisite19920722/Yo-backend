/**
 * 404 Studio Inc.
 * Copyright (c) 2014-2015 All Rights Reserved.
 */
package tiger.biz.attach.support;


import tiger.core.basic.BaseResult;
import tiger.core.domain.attach.AttachDomain;
import tiger.core.domain.attach.AttachRelateDomain;

import java.util.List;

/**
 * 负责对所有附件的关联操作
 *
 * @author yiliang.gyl
 * @version $ID: v 0.1 11:19 AM yiliang.gyl Exp $
 */
public interface AttachRelateManager {

    /**
     * 用户关联附件操作
     *
     * @param attachRelateDomain
     * @param accountId
     * @return
     */
    BaseResult<Boolean> relateAttach(AttachRelateDomain attachRelateDomain, Long accountId);

    /**
     * 用户删除附件关联操作
     *
     * @param attachRelateDomain
     * @return
     */
    BaseResult<Boolean> deRelateAttach(AttachRelateDomain attachRelateDomain);

    /**
     * 获取关联的附件操作
     *
     * @param attachRelateDomain
     * @return
     */
    BaseResult<List<AttachDomain>> listAttachs(AttachRelateDomain attachRelateDomain);
}
