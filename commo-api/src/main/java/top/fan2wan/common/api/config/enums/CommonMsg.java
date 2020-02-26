package top.fan2wan.common.api.config.enums;

import com.google.common.base.MoreObjects;
import top.fan2wan.common.api.config.dto.IMsg;

/**
 * @description: common msg
 * @author: FantTao
 * @date: 2020-02-24 14:32
 */
public enum CommonMsg implements IMsg {
    REPEAT_OPERATION(2001, "请勿重复点击"),
    TOKEN_ERROE(4001, "token异常"),
    REDIS_ERROE(5002, "redis 服务异常");

    int code;

    String message;

    CommonMsg(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 错误代码
     */
    @Override
    public int getCode() {
        return code;
    }

    /**
     * 错误信息
     */
    @Override
    public String getMsg() {
        return message;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("code", code)
                .add("message", message)
                .toString();
    }
}
