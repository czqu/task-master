package net.czqu.taskmaster.common.constant.error;

/**
 * @author Paul
 */

public enum ModuleEnum {
    /**
     * 用户模块
     */
    USER("user", "10");

    private String value;
    private String code;

    ModuleEnum(String value, String code) {
        this.value = value;
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public String getCode() {
        return code;
    }

}
