##spring-boot 整合Redis用例  
并没有使用spring的redis包，引用了redis.client的jedis包，maven[网址](https://mvnrepository.com/artifact/redis.clients/jedis)  
项目编译依赖于org.apache.commons » commons-pool2包。 

- 说明 
RedisPool用于单机版，RedisCluster用于集群版。  
单机通常用于开发环境，线上环境为集群环境。  
暂时没有做集群的用例。  

- Redis的初始化逻辑：
  1. 首先是RedisConfig类实现对本地配置的读取，注解@Configuration    
  2. 然后RedisPool中的静态方法initRedisConnection对连接进行初始化。
  3. 在使用时，直接通过注入RedisPool,然后就可以调用相关方法了

- 思考：
1.面向接口编程，在使用RedisPool时，是否可以使用RedisUtil,这样就屏蔽了Redis的配置方式，不用管是集群还是单机？该如何操作？