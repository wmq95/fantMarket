package top.fan2wan.user.feign;

/**
 * @description: hystrix for userApi
 * @author: FantTao
 * @date: 2020-02-17 14:40
 */
public class UserFeignHystrix implements UserFeignApi {
    @Override
    public String index() {
        return "error ,something is wrong ";
    }
}
