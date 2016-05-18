/**
 * 404 Studio Inc.
 * Copyright (c) 2014-2015 All Rights Reserved.
 */
package tiger.common.dal.enums;

/**
 * @author alfred.yx
 * @version $ID: v 0.1 下午5:37 alfred.yx Exp $
 */
public enum AttachTypeEnum implements BaseEnum {
    PUBLIC("PUBLIC", "公开附件"),
    SECRET("SECRET", "私有附件");

    private String code;
    private String value;
    AttachTypeEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public static AttachTypeEnum getEnumByCode(String code) {
        for (AttachTypeEnum attachTypeEnum : AttachTypeEnum.values()) {
            if (attachTypeEnum.getCode().equals(code)) {
                return attachTypeEnum;
            }
        }
        return null;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }
}
