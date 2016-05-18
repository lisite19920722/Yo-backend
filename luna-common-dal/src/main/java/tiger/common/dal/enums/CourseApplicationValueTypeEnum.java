/**
 * Gambition Inc.
 * All Right Reserved.
 */
package tiger.common.dal.enums;

/**
 * @Author: [mondooo.cgq]
 * @version: [V 0.1.1]
 * @CreateDate: [16/5/1 03:58]
 */
public enum CourseApplicationValueTypeEnum implements BaseEnum {

    BY_WECHAT("BY_WECHAT", "微信转账");

    private String code;
    private String value;

    CourseApplicationValueTypeEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public static CourseApplicationValueTypeEnum getEnumByCode(String code) {
        for (CourseApplicationValueTypeEnum courseApplicationValueTypeEnum : CourseApplicationValueTypeEnum.values()) {
            if (courseApplicationValueTypeEnum.getCode().equals(code)) {
                return courseApplicationValueTypeEnum;
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
