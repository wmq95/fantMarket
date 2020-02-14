# fantMarket

##目的
>整理目前知识，写一个简单的用户购买商品的逻辑

## 核心思想
>微服务架构

>根据DDD 去搭建后台

##编码规范
>基于阿里巴巴RestFul接口编写规范

>[阿里巴巴java手册](https://cdn.ai-english.com.cn/docs/%E9%98%BF%E9%87%8C%E5%B7%B4%E5%B7%B4Java%E6%89%8B%E5%86%8C.pdf)


## 工程结构规范
### 应用分层
- controller-》service-》manager-》外部接口及第三方平台
- controller-》service-》dao-》数据库

注意点:
> 所有的第三方服务及其他微服务方法调用必须通过manager来承载，非manager类中不可出现第三方服务及其他微服务中定义的dto等类，如需使用请在本服务工程中新建BO类来传递数据


### 领域模型
