package top.fan2wan.order.config;

import top.fan2wan.common.web.config.AbstractHibernateConfig;

/**
 * @description: order service config for hibernate
 * @author: FantTao
 * @date: 2020-02-14 11:13
 */
public class OrderHibernateConfig extends AbstractHibernateConfig {
    @Override
    public String entityPackage() {
        return "top.fan2wan.order.entity";
    }
}
