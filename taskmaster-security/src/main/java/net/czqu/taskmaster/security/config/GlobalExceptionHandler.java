package net.czqu.taskmaster.security.config;


import net.czqu.taskmaster.common.constant.exception.BaseException;
import net.czqu.taskmaster.common.response.ResponseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @program: Open-IM-Server-In-Java
 * @description:
 * @author: czq
 * @create: 2023-01-08 22:06
 **/

@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseResult runtimeExceptionHandler(Exception ex) {
        return ResponseResult.error().msg(ex.toString()).code("500");
    }

    @ResponseBody
    public ResponseResult internalExceptionHandler(BaseException ex) {
        return ResponseResult.error().code(ex.getCode()).msg(ex.getErrMsg()).errCode(ex.getErrCode());
    }


}
