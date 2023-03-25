package net.czqu.taskmaster.common.constant.exception;

/**
 * @author czqu
 *
 */
public interface IBaseException {
    /**
     * 返回错误信息
     * @author: czq
     * @method: getErrMsg
     * @param:
     * @return 错误信息
     */
    public String getErrMsg();
    /**
     * 返回错误代码（老）
     * @author: czq
     * @method: getErrCode
     * @return
     */
    public String getErrCode();
    /**
     * 返回错误代码（新）
     * @author: czq
     * @method: getCode()
     * @return 错误代码
     */
    public String getCode();
}
