/**
 * 404 Studio Inc.
 * Copyright (c) 2014-2015 All Rights Reserved.
 */
package tiger.web.api.form.attach;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import tiger.common.util.BeanUtil;
import tiger.common.util.StringUtil;
import tiger.core.domain.attach.AttachRelateDomain;
import tiger.web.api.form.FormInterface;

import javax.validation.constraints.NotNull;

/**
 * @author yiliang.gyl
 * @version $ID: v 0.1 8:49 PM yiliang.gyl Exp $
 */
public class AttachRelateForm implements FormInterface {

    @NotNull(message = "附件attachId不能为空")
    private Long attachId;

    private String type;

    public Long getAttachId() {
        return attachId;
    }

    public void setAttachId(Long attachId) {
        this.attachId = attachId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public AttachRelateDomain convert2Domain() {
        AttachRelateDomain target = new AttachRelateDomain();
        BeanUtil.copyPropertiesWithIgnores(this, target);
        if (StringUtil.isNotBlank(type)) {

        }
        return target;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
