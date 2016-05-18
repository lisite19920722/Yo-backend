package tiger.common.dal.enums;

/**
 * Created by globit on 9/1/15.
 */
public enum PermissionEnum implements BaseEnum {


    //Workspace相权限
    VIEW_WORKSPACE("VIEW_WORKSPACE", "查看团队空间"),
    VIEW_WORKSPACE_MEMBER("VIEW_WORKSPACE_MEMBER", "获取团队成员列表"),
    DELETE_WORKSPACE("DELETE_WORKSPACE", "解散团队"),
    DELETE_WORKSPACE_MEMBER("DELETE_WORKSPACE_MEMBER", "移除团队成员"),
    UPDATE_WORKSPACE_INFO("UPDATE_WORKSPACE_INFO", "更新团队基本信息"),
    UPDATE_WORKSPACE_MEMBER_ROLE("UPDATE_WORKSPACE_MEMBER_ROLE", "更新团队成员角色"),
    UPDATE_WORKSPACE_TRANSFER_OWNER("UPDATE_WORKSPACE_TRANSFER_OWNER", "移交团队所有者"),
    UPDATE_WORKSPACE_INVITE_MEMBER("UPDATE_WORKSPACE_INVITE_MEMBER", "邀请团队成员"),
    UPDATE_WORKSPACE_CONFIGURATION("UPDATE_WORKSPACE_CONFIGURATION", "修改团队配置"),

    // Loan 相关权限
    CREATE_LOAN("CREATE_LOAN", "创建贷款项目"),
    CREATE_LOAN_TEMPLATE("CREATE_LOAN_TEMPLATE", "创建一个贷款项目模版"),

    DELETE_LOAN_TEMPORARY_MEMBER("DELETE_LOAN_TEMPORARY_MEMBER", "将个人贷款项目放入垃圾箱"),
    DELETE_LOAN_TEMPORARY_ALL("DELETE_LOAN_TEMPORARY_ALL", "将工作组贷款项目放入垃圾箱"),
    DELETE_LOAN_PERMANENTLY_MEMBER("DELETE_LOAN_PERMANENTLY_MEMBER", "彻底删除个人贷款项目"),
    DELETE_LOAN_PERMANENTLY_ALL("DELETE_LOAN_PERMANENTLY_ALL", "彻底删除工作组贷款项目"),
    DELETE_LOAN_TEMPLATE("DELETE_LOAN_TEMPLATE", "删除贷款项目模版"),

    UPDATE_LOAN_MEMBER("UPDATE_LOAN_MEMBER", "更新个人贷款项目"),
    UPDATE_LOAN_ALL("UPDATE_LOAN_ALL", "更新工作组贷款项目"),
    UPDATE_LOAN_TEMPLATE("UPDATE_LOAN_TEMPLATE", "更新贷款项目模版"),
    UPDATE_LOAN_RECOVERY_MEMBER("UPDATE_LOAN_RECOVERY_MEMBER", "将个人贷款项目从垃圾箱中恢复"),
    UPDATE_LOAN_RECOVERY_ALL("UPDATE_LOAN_RECOVERY_ALL", "将工作组贷款项目从垃圾箱中恢复"),
    UPDATE_LOAN_COLLECT_BILL_MEMBER("UPDATE_LOAN_COLLECT_BILL_MEMBER", "收取个人贷款项目还款帐单"),
    UPDATE_LOAN_COLLECT_BILL_ALL("UPDATE_LOAN_COLLECT_BILL_ALL", "收取工作组贷款项目还款帐单"),
    UPDATE_LOAN_LAUNCH_MEMBER("UPDATE_LOAN_LAUNCH_MEMBER", "个人贷款项目放款"),
    UPDATE_LOAN_LAUNCH_ALL("UPDATE_LOAN_LAUNCH_ALL", "工作组贷款项目放款"),
    UPDATE_LOAN_MODIFICATION_MEMBER("UPDATE_LOAN_MODIFICATION_MEMBER", "更新个人贷款项目异常收支"),
    UPDATE_LOAN_MODIFICATION_ALL("UPDATE_LOAN_MODIFICATION_ALL", "更新工作组贷款项目异常收支"),
    UPDATE_LOAN_REFINEMENT_MEMBER("UPDATE_LOAN_REFINEMENT_MEMBER", "调整个人贷款项目"),
    UPDATE_LOAN_REFINEMENT_ALL("UPDATE_LOAN_REFINEMENT_ALL", "调整工作组贷款项目"),
    UPDATE_LOAN_PAYBACK_MEMBER("UPDATE_LOAN_PAYBACK_MEMBER", "撤销个人贷款项目最近一次还款记录"),
    UPDATE_LOAN_PAYBACK_ALL("UPDATE_LOAN_PAYBACK_ALL", "撤销工作组贷款项目最近一次还款记录"),
    UPDATE_LOAN_ASSIGN("UPDATE_LOAN_ASSIGN", "指派工作组贷款项目给工作组成员"),

    VIEW_LOAN_MEMBER("VIEW_LOAN_MEMBER", "查看个人工作空间贷款项目"),
    VIEW_LOAN_ALL("VIEW_LOAN_ALL", "查看工作组贷款项目"),
    VIEW_LOAN_TEMPLATE("VIEW_LOAN_TEMPLATE", "查看贷款项目模版"),

    // 财务统计相关权限
    VIEW_FISCALS_ALL("VIEW_FISCALS_ALL", "查看工作组财务统计信息"),
    VIEW_FISCALS_MEMBER("VIEW_FISCALS_MEMBER", "查看个人财务统计信息"),

    //客户相关权限
    CREATE_CUSTOMER_MEMBER("CREATE_CUSTOMER_MEMBER","创建个人工作空间客户"),
    CREATE_CUSTOMER_ALL("CREATE_CUSTOMER_ALL","创建工作组客户"),
    VIEW_CUSTOMER_MEMBER("VIEW_CUSTOMER_MEMBER","查看个人工作空间客户"),
    VIEW_CUSTOMER_ALL("VIEW_CUSTOMER_ALL","查看工作组客户"),
    UPDATE_CUSTOMER_MEMBER("UPDATE_CUSTOMER_MEMBER","更新个人工作空间客户"),
    UPDATE_CUSTOMER_ALL("UPDATE_CUSTOMER_ALL","更新工作组客户"),
    DELETE_CUSTOMER_MEMBER("DELETE_CUSTOMER_MEMBER","删除个人工作空间客户"),
    DELETE_CUSTOMER_ALL("DELETE_CUSTOMER_ALL","删除工作组客户"),
    UPDATE_CUSTOMER_TRANSFER_MEMBER("UPDATE_CUSTOMER_TRANSFER_MEMBER","转移个人工作空间客户"),
    UPDATE_CUSTOMER_TRANSFER_ALL("UPDATE_CUSTOMER_TRANSFER_ALL","转移工作组客户"),
    ;
    /**
     * 枚举的值
     */
    private String code;

    /**
     * 枚举描述
     */
    private String value;

    PermissionEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public static PermissionEnum getEnumByCode(String code) {
        for (PermissionEnum attachTypeEnum : PermissionEnum.values()) {
            if (attachTypeEnum.getCode().equals(code)) {
                return attachTypeEnum;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
