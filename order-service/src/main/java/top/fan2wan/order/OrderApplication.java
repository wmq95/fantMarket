package top.fan2wan.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import top.fan2wan.common.web.config.FeignConfig;
import top.fan2wan.common.web.config.WebBootConfig;
import top.fan2wan.order.config.OrderHibernateConfig;
import top.fan2wan.user.feign.UserFeignHystrix;

/**
 * @description: application of orderService
 * @author: FantTao
 * @date: 2020-02-10 17:09
 */
@SpringBootApplication
@Import({
        OrderHibernateConfig.class,
        FeignConfig.class,
        WebBootConfig.class})
public class OrderApplication {

    @Bean
    UserFeignHystrix userFeignHystrix() {
        return new UserFeignHystrix();
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
