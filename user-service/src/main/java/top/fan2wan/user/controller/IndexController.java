package top.fan2wan.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fan2wan.common.web.annotation.Idempotent;
import top.fan2wan.common.web.controller.BaseController;

import static top.fan2wan.common.web.constants.TokenConstant.TOKEN_NAME;

/**
 * @description: test for Controller of module
 * @author: FantTao
 * @date: 2020-02-10 12:11
 */
@RestController
public class IndexController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    RedisTemplate template;

    @Idempotent
    @RequestMapping("/index")
    public String helloModule() {
        logger.info("hello {},do something ,,,,,,", request.getHeader(TOKEN_NAME));
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "call success";
    }
}
