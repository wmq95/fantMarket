package top.fan2wan.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fan2wan.common.web.controller.BaseController;
import top.fan2wan.user.entity.UserEntity;
import top.fan2wan.user.feign.UserFeignApi;
import top.fan2wan.user.repository.UserRepository;

import java.util.List;

/**
 * @description: user Controller
 * @author: FantTao
 * @date: 2020-02-10 12:35
 */
@RestController
public class UserController extends BaseController implements UserFeignApi {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public String index() {
        logger.info("insert user ....");
        UserEntity userEntity = new UserEntity();
        userEntity.setName("test User");
        userEntity.setTelephone("13921114098");
        return userRepository.save(userEntity).toString();
    }

    @RequestMapping("/transaction")
    @Transactional
    public String transaction() {
        UserEntity userEntity = new UserEntity();
        userEntity.setName("test User");
        userEntity.setTelephone("13921114098");
        userRepository.save(userEntity);
        logger.info("save user,result was :{}", userEntity);
        int i = userEntity.getId().intValue() / 0;
        return String.valueOf(i);
    }

    @RequestMapping("/listUser")
    public List<UserEntity> listUser() {
        return userRepository.findAll();
    }

    @RequestMapping("/clear")
    public boolean clearData() {
        userRepository.deleteAll();
        return true;
    }
}
