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
public enum CourseApplicationTypeEnum implements BaseEnum {

    REFUND_AT_END("REFUND_AT_END", "期末赌金回退");

    private String code;
    private String value;

    CourseApplicationTypeEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public static CourseApplicationTypeEnum getEnumByCode(String code) {
        for (CourseApplicationTypeEnum courseApplicationTypeEnum : CourseApplicationTypeEnum.values()) {
            if (courseApplicationTypeEnum.getCode().equals(code)) {
                return courseApplicationTypeEnum;
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
