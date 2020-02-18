package top.fan2wan.user.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: user API
 * @author: FT
 * @date: 2020-02-10 12:31
 */
@FeignClient(name = "userService", fallback = UserFeignHystrix.class)
public interface UserFeignApi {

    @RequestMapping("/user/index")
    String index();
}
