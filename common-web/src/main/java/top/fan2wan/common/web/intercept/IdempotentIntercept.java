package top.fan2wan.common.web.intercept;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import top.fan2wan.common.api.config.exception.BusinessException;
import top.fan2wan.common.web.annotation.Idempotent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static java.util.Objects.nonNull;
import static top.fan2wan.common.api.config.enums.CommonMsg.TOKEN_ERROE;
import static top.fan2wan.common.web.constants.TokenConstant.TOKEN_MARK;

/**
 * @description: intercept for idempotent controller
 * @author: FantTao
 * @date: 2020-02-14 10:49
 */
public class IdempotentIntercept implements HandlerInterceptor {

    private static Logger logger = LoggerFactory.getLogger(IdempotentIntercept.class);

//    @Autowired
//    StringRedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        } else {
            HandlerMethod method = (HandlerMethod) handler;
            Idempotent idempotent = method.getMethodAnnotation(Idempotent.class);
            if (null != idempotent) {
                if (nonNull(request.getHeader(TOKEN_MARK))) {
                    logger.info("controller need check for idempotent");
                    checkRequest(request.getHeader(TOKEN_MARK));
                } else {
                    throw new BusinessException(TOKEN_ERROE);
                }
            }
        }
        return true;
    }

    /**
     * check idempotent for controller
     *
     * @param request
     */
    private void checkRequest(String request) {
//        do check.......
//        redisTemplate.hasKey(request);
    }
}
