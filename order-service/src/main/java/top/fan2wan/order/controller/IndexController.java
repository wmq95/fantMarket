package top.fan2wan.order.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fan2wan.user.feign.UserFeignApi;

/**
 * @description: indexController for order
 * @author: FantTao
 * @date: 2020-02-10 17:08
 */
@RestController
public class IndexController {

    private static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    UserFeignApi userFeignApi;

    @RequestMapping("/index")
    public String index() {
        logger.info("call userFeign.....");
        return userFeignApi.index();
    }

    @RequestMapping("/actuator/health")
    public String health() {
        return "ok";
    }
}
