package top.fan2wan.order.config;

import org.springframework.context.annotation.Profile;
import top.fan2wan.common.web.config.AbstractHibernateConfig;

/**
 * @description: order service config for hibernate
 * @author: FantTao
 * @date: 2020-02-14 11:13
 */
@Profile("prod")
public class OrderHibernateConfig extends AbstractHibernateConfig {

    @Override
    public String entityPackage() {
        return "top.fan2wan.order.entity";
    }
}
