/**
 * Gambition Inc.
 * All Right Reserved.
 */
package tiger.common.dal.enums;

/**
 * @Author: [mondooo.cgq]
 * @version: [V 0.1.1]
 * @CreateDate: [16/4/25 18:31]
 */
public enum CourseTypeEnum implements BaseEnum {

    PUBLIC("PUBLIC", "公开课程"),
    PRIVATE("PRIVATE", "私有课程");

    private String code;
    private String value;

    CourseTypeEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public static CourseTypeEnum getEnumByCode(String code) {
        for (CourseTypeEnum courseTypeEnum : CourseTypeEnum.values()) {
            if (courseTypeEnum.getCode().equals(code)) {
                return courseTypeEnum;
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
