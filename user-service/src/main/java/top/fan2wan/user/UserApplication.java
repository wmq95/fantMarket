package top.fan2wan.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import top.fan2wan.common.web.config.FeignConfig;
import top.fan2wan.common.web.config.RedisConfig;
import top.fan2wan.common.web.config.WebBootConfig;
import top.fan2wan.user.config.UserHibernateConfig;

/**
 * @description: config of user Application
 * @author: FantTao
 * @date: 2020-02-10 12:01
 */
@SpringBootApplication
@Import({UserHibernateConfig.class,
        FeignConfig.class,
        RedisConfig.class,
        WebBootConfig.class})
public class UserApplication {

    private static Logger logger = LoggerFactory.getLogger(UserApplication.class);

    public static void main(String[] args) {
        logger.info("service start..........");
        SpringApplication.run(UserApplication.class, args);
    }
}
