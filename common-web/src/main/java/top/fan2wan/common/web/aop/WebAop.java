package top.fan2wan.common.web.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @description: common web AOP
 * @author: FantTao
 * @date: 2020-02-11 9:39
 */
@Aspect
public class WebAop {

    @Pointcut("execution(* top.fan2wan.*.controller.*Controller.*(..))")
    public void loggerAop() {
    }

    @Before("loggerAop()")
    public void logger() {
//        ....do some logger here
    }
}
