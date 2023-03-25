package net.czqu.taskmaster.common.response;

import java.io.Serializable;

/**
 * @author czqu
 */
public class ResponseResult<T> implements Serializable {
    private static final long serialVersionUID = 9091608525873740724L;
    private String errCode = "";
    private String errMsg = "";
    private String code = "";
    private T data;

    private ResponseResult() {
    }

    @SuppressWarnings("rawtypes")
    public static ResponseResult success() {
        return success(null);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static ResponseResult success(Object data) {
        ResponseResult responseResult = new ResponseResult<>();
        responseResult.setErrCode(ResultCode.SUCCESS.getErrCode());
        responseResult.setErrMsg(ResultCode.SUCCESS.getMessage());
        responseResult.setData(data);

        return responseResult;
    }

    @SuppressWarnings("rawtypes")
    public static ResponseResult error() {
        return error("");
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static ResponseResult error(Object data) {
        ResponseResult responseResult = new ResponseResult<>();
        responseResult.setErrCode(ResultCode.SUCCESS.getErrCode());
        responseResult.setErrMsg(ResultCode.SUCCESS.getMessage());
        responseResult.setData(data);

        return responseResult;
    }

    @SuppressWarnings("rawtypes")
    public ResponseResult data(T data) {
        this.setData(data);
        return this;
    }

    @SuppressWarnings("rawtypes")
    public ResponseResult code(String code) {
        this.setCode(code);
        return this;
    }

    public ResponseResult errCode(String code) {
        this.setErrCode(code);
        return this;
    }

    @SuppressWarnings("rawtypes")
    public ResponseResult msg(String msg) {
        this.setErrMsg(msg);
        return this;
    }

    @Override
    public String toString() {
        return "RestResult{" + "code=" + errCode + ", msg='" + errMsg + '\'' + ", data=" + data + '}';
    }

    public String getErrCode() {
        return errCode;
    }

    public ResponseResult<T> setErrCode(String errCode) {
        this.errCode = errCode;
        return this;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public ResponseResult<T> setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseResult<T> setData(T data) {
        this.data = data;
        return this;
    }

    public String getCode() {
        return code;
    }

    public ResponseResult<T> setCode(String code) {
        this.code = code;
        return this;
    }
}