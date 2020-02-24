package top.fan2wan.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fan2wan.common.web.annotation.Idempotent;

/**
 * @description: test for Controller of module
 * @author: FantTao
 * @date: 2020-02-10 12:11
 */
@RestController
public class IndexController {
    @Idempotent
    @RequestMapping("/index")
    public String helloModule() {
        return "hello ft";
    }

  /*  @RequestMapping("/actuator/health")
    public String health() {
        return "ok";
    }*/
}
