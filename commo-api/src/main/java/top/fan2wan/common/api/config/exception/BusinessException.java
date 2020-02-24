package top.fan2wan.common.api.config.exception;

import top.fan2wan.common.api.config.dto.IMsg;

/**
 * @description: businessce exception
 * @author: FantTao
 * @date: 2020-02-24 14:53
 */
public class BusinessException extends BaseException {
    public BusinessException(int code, String msg) {
        super(code, msg);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(IMsg iMsg) {
        super(iMsg.getCode(), iMsg.getMsg());
    }
}
