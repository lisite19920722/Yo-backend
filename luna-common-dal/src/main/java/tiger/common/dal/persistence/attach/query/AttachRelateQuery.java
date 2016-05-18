/**
 * 404 Studio Inc.
 * Copyright (c) 2014-2015 All Rights Reserved.
 */
package tiger.common.dal.persistence.attach.query;

import tiger.common.dal.enums.AttachBizTypeEnum;
import tiger.common.dal.persistence.BaseQuery;

/**
 * @author yiliang.gyl
 * @version $ID: v 0.1 1:56 PM yiliang.gyl Exp $
 */
public class AttachRelateQuery extends BaseQuery {

    private Long subjectId;

    private AttachBizTypeEnum bizTypeEnum;

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public AttachBizTypeEnum getBizTypeEnum() {
        return bizTypeEnum;
    }

    public void setBizTypeEnum(AttachBizTypeEnum bizTypeEnum) {
        this.bizTypeEnum = bizTypeEnum;
    }
}
