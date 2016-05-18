/**
 * Gambition Inc.
 * All Right Reserved.
 */
package tiger.common.dal.enums;

/**
 * @Author: [mondooo.cgq]
 * @version: [V 0.1.1]
 * @CreateDate: [16/5/1 06:50]
 */
public enum CourseApplicationStateEnum implements BaseEnum{
    PASS("PASS", "通过"),
    UNPASS("UNPASS", "不通过");

    private String code;
    private String value;

    CourseApplicationStateEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public static CourseApplicationStateEnum getEnumByCode(String code) {
        for (CourseApplicationStateEnum applicationStateEnum : CourseApplicationStateEnum.values()) {
            if (applicationStateEnum.getCode().equals(code)) {
                return applicationStateEnum;
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
