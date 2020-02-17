package top.fan2wan.order.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fan2wan.common.web.controller.BaseController;
import top.fan2wan.order.entity.OrderEntity;
import top.fan2wan.order.repository.TestRepository;
import top.fan2wan.user.feign.UserFeignApi;

/**
 * @description: indexController for order
 * @author: FantTao
 * @date: 2020-02-10 17:08
 */
@RestController
public class IndexController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    UserFeignApi userFeignApi;

    @Autowired
    TestRepository testRepository;

    @RequestMapping("/index")
    public String index() {
        logger.info("call userFeign.....");
        logger.info("obtain user form request ,user was:{}", request.getHeader("user"));
        request.setAttribute("user","user");
        return userFeignApi.index();
    }

    @RequestMapping("/save")
    public OrderEntity save() {
        OrderEntity entity = new OrderEntity();
//        entity.setId(1L);
        entity.setName("save test");
        entity.setPrice(0.1);
        return testRepository.save(entity);
    }

    @RequestMapping("/actuator/health")
    public String health() {
        return "ok";
    }
}
