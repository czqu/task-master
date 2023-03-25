package net.czqu.taskmaster.common.constant.exception;

/**
 * @description:
 * @author: czq
 * @create: 2023-01-16 20:54
 **/
public class BaseException extends Exception implements IBaseException {
    private IBaseErrorCode errorCode;
    private String msg;

    public BaseException(String msg, IBaseErrorCode errorCode) {
        this.errorCode = errorCode;
        this.msg = msg;
    }

    @Override
    public String getErrMsg() {
        return msg;
    }

    @Override
    public String getErrCode() {
        return errorCode.getErrCode();
    }

    @Override
    public String getCode() {
        return errorCode.getFullErrCode();
    }
}
