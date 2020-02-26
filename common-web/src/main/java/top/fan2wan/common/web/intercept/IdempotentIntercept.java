package top.fan2wan.common.web.intercept;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import top.fan2wan.common.api.config.exception.BusinessException;
import top.fan2wan.common.web.annotation.Idempotent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

import static java.util.Objects.nonNull;
import static top.fan2wan.common.api.config.enums.CommonMsg.REDIS_ERROE;
import static top.fan2wan.common.api.config.enums.CommonMsg.REPEAT_OPERATION;
import static top.fan2wan.common.api.config.enums.CommonMsg.TOKEN_ERROE;
import static top.fan2wan.common.web.constants.TokenConstant.TOKEN_NAME;

/**
 * @description: intercept for idempotent method
 * @author: FantTao
 * @date: 2020-02-14 10:49
 */
public class IdempotentIntercept implements HandlerInterceptor {

    private static Logger logger = LoggerFactory.getLogger(IdempotentIntercept.class);

    public IdempotentIntercept(RedisTemplate template) {
        this.template = template;
    }

    private RedisTemplate template;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        } else {
            HandlerMethod method = (HandlerMethod) handler;
            Idempotent idempotent = method.getMethodAnnotation(Idempotent.class);
            if (null != idempotent) {
                String token = request.getHeader(TOKEN_NAME);
                if (nonNull(token)) {
                    logger.info("token was:{},method was:{},need to check for idempotent", token, method.getMethod().getClass() + method.getMethod().getName());
                    checkRequest(token, request.toString());
                } else {
                    throw new BusinessException(TOKEN_ERROE);
                }
            }
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;
            Idempotent idempotent = method.getMethodAnnotation(Idempotent.class);
            if (null != idempotent) {
                if (!template.delete(request.getHeader(TOKEN_NAME))) {
                    throw new BusinessException(REDIS_ERROE);
                }
            }
        }
    }

    /**
     * check idempotent for controller
     *
     * @param token
     * @param request
     */
    private void checkRequest(String token, String request) {
        if (this.template.hasKey(token)) {
//            return
            throw new BusinessException(REPEAT_OPERATION);
        } else {
//            set redis key-token,value-request.toString
            setKeyAndValue(token, request);
            if (!request.equals(getValue(token))) {
//                check request for concurrency
                throw new BusinessException(REPEAT_OPERATION);
            }
        }
    }

    public void setKeyAndValue(String key, String value) {
        ValueOperations<String, String> ops = this.template.opsForValue();
        ops.setIfAbsent(key, value, 1, TimeUnit.MINUTES);
    }


    public String getValue(String key) {
        ValueOperations<String, String> ops = this.template.opsForValue();
        return ops.get(key);
    }
}
