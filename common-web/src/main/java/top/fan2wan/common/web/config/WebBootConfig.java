package top.fan2wan.common.web.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.fan2wan.common.web.intercept.IdempotentIntercept;

/**
 * @description: common config for web
 * @author: FantTao
 * @date: 2020-02-11 10:07
 */
@Configuration
@EnableDiscoveryClient
public class WebBootConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new IdempotentIntercept());
    }
}
