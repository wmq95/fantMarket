package top.fan2wan.user.controller;

import org.springframework.web.bind.annotation.RestController;
import top.fan2wan.user.feign.UserFeignApi;

/**
 * @description: user Controller
 * @author: FantTao
 * @date: 2020-02-10 12:35
 */
@RestController
public class UserController implements UserFeignApi {
    @Override
    public String index() {
        return "this is user Controller";
    }
}
