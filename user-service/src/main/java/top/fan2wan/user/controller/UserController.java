package top.fan2wan.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import top.fan2wan.common.web.controller.BaseController;
import top.fan2wan.user.feign.UserFeignApi;

/**
 * @description: user Controller
 * @author: FantTao
 * @date: 2020-02-10 12:35
 */
@RestController
public class UserController extends BaseController implements UserFeignApi {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Override
    public String index() {
        logger.info("obtain form request Header,user was :{}", request.getHeader("user"));
        logger.info("obtain form request Attribute,user was :{}", request.getAttribute("user"));
        return "this is user Controller";
    }
}
