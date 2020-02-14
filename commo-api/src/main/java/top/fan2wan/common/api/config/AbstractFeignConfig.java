package top.fan2wan.common.api.config;

import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @description: config for feign
 * @author: FantTao
 * @date: 2020-02-14 12:11
 */
@EnableFeignClients(basePackages = {"top.fan2wan.*.feign"})
public abstract class AbstractFeignConfig {
}
