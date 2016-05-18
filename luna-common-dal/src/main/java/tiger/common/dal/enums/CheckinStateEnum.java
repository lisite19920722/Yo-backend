/**
 * Gambition Inc.
 * All Right Reserved.
 */
package tiger.common.dal.enums;

/**
 * @Author: [mondooo.cgq]
 * @version: [V 0.1.1]
 * @CreateDate: [16/4/26 19:08]
 */
public enum CheckinStateEnum implements BaseEnum {
    PASS("PASS", "通过"),
    PENDING("PENDING", "待审核"),
    UNPASS("UNPASS", "不通过"),
    AUTOPASS("AUTOPASS", "自动审核");

    private String code;
    private String value;

    CheckinStateEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public static CheckinStateEnum getEnumByCode(String code) {
        for (CheckinStateEnum checkinStateEnum : CheckinStateEnum.values()) {
            if (checkinStateEnum.getCode().equals(code)) {
                return checkinStateEnum;
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
