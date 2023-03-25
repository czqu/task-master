package net.czqu.taskmaster.common.constant.exception;

/**
 * @description:
 * @author: czq
 * @create: 2023-01-16 21:42
 **/
public class UserAccountException extends BaseException {
    public UserAccountException(String msg, IBaseErrorCode errorCode) {
        super(msg, errorCode);
    }
}
