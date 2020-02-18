package top.fan2wan.common.web.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.fan2wan.common.api.config.AbstractFeignConfig;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @description: config for feign
 * @author: FantTao
 * @date: 2020-02-14 12:15
 */
@Configuration
public class FeignConfig extends AbstractFeignConfig implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
//                .getRequestAttributes();
//        if (attributes != null) {
//            HttpServletRequest request = attributes.getRequest();
//            Enumeration<String> headerNames = request.getHeaderNames();
//            if (headerNames != null) {
//                while (headerNames.hasMoreElements()) {
//                    String name = headerNames.nextElement();
////                    if (!Arrays.asList(feignHeaderNames).contains(name.toLowerCase())) {
////                        continue;
////                    } else {
//                    String values = request.getHeader(name);
//                    requestTemplate.header(name, values);
////                    }
//                }
//            }
//        }
    }
}
