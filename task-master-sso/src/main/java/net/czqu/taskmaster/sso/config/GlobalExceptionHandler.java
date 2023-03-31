package net.czqu.taskmaster.sso.config;

import net.czqu.taskmaster.common.constant.exception.BaseException;
import net.czqu.taskmaster.common.constant.exception.UserAccountException;
import net.czqu.taskmaster.common.response.ResponseResult;
import org.springframework.security.core.AuthenticationException;
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
    @ExceptionHandler(AuthenticationException.class)
    public ResponseResult authenticationExceptionExceptionHandler(AuthenticationException ex) {
        return ResponseResult.error().msg(ex.getMessage()).code("401");
    }
    @ResponseBody
    @ExceptionHandler(UserAccountException.class)
    public ResponseResult defaultExceptionHandler(UserAccountException ex) {
        return ResponseResult.error().msg(ex.getMessage()).code("401");
    }
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseResult defaultExceptionHandler(Exception ex) {
        return ResponseResult.error().msg(ex.getMessage()).code("500");
    }

    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public ResponseResult runtimeExceptionHandler(RuntimeException ex) {
        return ResponseResult.error().code("500").msg(ex.getMessage());
    }


}