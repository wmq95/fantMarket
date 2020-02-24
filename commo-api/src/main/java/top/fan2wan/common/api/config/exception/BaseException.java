package top.fan2wan.common.api.config.exception;

/**
 * @description: base exception
 * @author: FantTao
 * @date: 2020-02-24 14:07
 */
public abstract class BaseException extends RuntimeException {
    int code;
    String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public BaseException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getMessage() {
        return this.msg;
    }
}
