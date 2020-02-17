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

//    @Override
//    @Profile("dev")
//    public DataSource dataSource() {
//        System.out.println("dev datasource for mysql");
//        return DataSourceBuilder.create()
//                .driverClassName("com.mysql.cj.jdbc.Driver")
//                .url("jdbc:mysql://www.fan2wan.top:7777/testSpring?useUnicode=true&characterEncoding=utf8&characterSetResults=utf8")
//                .username("fant")
//                .password("123456")
//                .build();
//    }
}
