package top.fan2wan.common.web.intercept;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import top.fan2wan.common.web.annotation.Idempotent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: intercept for idempotent controller
 * @author: FantTao
 * @date: 2020-02-14 10:49
 */
public class IdempotentIntercept implements HandlerInterceptor {

    private static Logger logger = LoggerFactory.getLogger(IdempotentIntercept.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        } else {
            HandlerMethod method = (HandlerMethod) handler;
            Idempotent idempotent = method.getMethodAnnotation(Idempotent.class);
            if (idempotent != null) {
                logger.info("controller need check for idempotent");
                checkRequest(request);
            }
        }
        return true;
    }

    /**
     * check idempotent for controller
     *
     * @param request
     */
    private void checkRequest(HttpServletRequest request) {
//        do check.......
    }
}
