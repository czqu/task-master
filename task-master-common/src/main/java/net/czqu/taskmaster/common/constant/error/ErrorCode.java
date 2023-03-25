package net.czqu.taskmaster.common.constant.error;


import net.czqu.taskmaster.common.constant.exception.IBaseErrorCode;

/**
 * @description:
 * @author: czq
 * @create: 2023-01-16 21:22
 * @param: <errCode><为了兼容>
 **/

public enum ErrorCode implements IBaseErrorCode {
    //
    //    500", "操作失败
    // "404", "参数检验失败"),
    //   401", "暂未登录或token已经过期
    //  "403", "没有相关权限
    // user
    USER_NOT_FOUND(ModuleEnum.USER, ExceptionLevelEnum.ERROR, "00", "user not found", "404"),
    USER_ID_INVALID(ModuleEnum.USER, ExceptionLevelEnum.ERROR, "01", "user id invalid", "404"),
    USER_UNKNOWN_ERROR(ModuleEnum.USER, ExceptionLevelEnum.ERROR, "01", "user id invalid", "500"),
    ;
    private ModuleEnum module;
    private ExceptionLevelEnum level;
    private String code;
    private String msg;
    private String errCode;

    ErrorCode(ModuleEnum module, ExceptionLevelEnum exceptionLevelEnum, String code, String msg, String errCode) {
        this.module = module;
        this.level = exceptionLevelEnum;
        this.code = code;
        this.msg = msg;
        this.errCode = errCode;
    }

    @Override
    public String getModule() {
        return module.getValue();
    }

    @Override
    public String getLevel() {
        return level.getValue();
    }

    @Override
    public String getErrCode() {
        return errCode;
    }

    @Override
    public String getFullErrCode() {
        StringBuilder sb = new StringBuilder();
        sb.append(module.getCode());
        sb.append(level.getId());
        sb.append(code);
        return sb.toString();
    }


}
