package net.czqu.taskmaster.common.constant.error;

/**
 * @description:
 * @author: czq
 * @create: 2023-01-16 20:54
 **/
public enum ExceptionLevelEnum {
    /**
     * 信息
     */
    INFO(0, "info"),
    /**
     * 警告
     */
    WARN(1, "warn"),
    /**
     * 错误
     */
    ERROR(2, "error");

    ExceptionLevelEnum(int id, String value) {
        this.id = id;
        this.value = value;
    }

    ExceptionLevelEnum(int id, String value, String description) {
        this.id = id;
        this.value = value;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    private int id;
    private String value;
    private String description;
}
