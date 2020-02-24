package top.fan2wan.user.config;

import org.springframework.context.annotation.Profile;
import top.fan2wan.common.web.config.AbstractHibernateConfig;

/**
 * @description: hibernate config for userService
 * @author: FantTao
 * @date: 2020-02-11 10:43
 */
@Profile("prod")
public class UserHibernateConfig extends AbstractHibernateConfig {
    @Override
    public String entityPackage() {
        return "top.fan2wan.user.entity";
    }
}
