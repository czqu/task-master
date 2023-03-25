package net.czqu.taskmaster.common.response;

/**
 * @program: Open-IM-Server-In-Java
 * @description:
 * @author: czq
 * @create: 2022-12-24 15:27
 **/
public enum ResultCode {
    /* 成功 */
    SUCCESS("", "", "0"),
    /* 操作失败 */
    FAILED("500", "操作失败", "0"),
    /* 参数检验失败 */
    VALIDATE_FAILED("404", "参数检验失败", "0"),
    /* 暂未登录或token已经过期 */
    UNAUTHORIZED("401", "暂未登录或token已经过期", "0"),
    /* 没有相关权限 */
    FORBIDDEN("403", "没有相关权限", "0");

    private String errCode;
    private String message;
    private String code;

    @SuppressWarnings("PMD")
    private ResultCode(String errCode, String message, String code) {
        this.errCode = errCode;
        this.code = code;
        this.message = message;
    }

    public String getErrCode() {
        return errCode;
    }

    public String getMessage() {
        return message;
    }

}