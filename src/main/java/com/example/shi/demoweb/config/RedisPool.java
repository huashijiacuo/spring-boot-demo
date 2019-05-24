package com.example.shi.demoweb.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.*;
import redis.clients.jedis.exceptions.JedisException;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shihsh  </br>
 * @version V1.0
 * @title RedisPool </br>
 * @createDate 2019/5/23 22:24 </br>
 * @description 单机模式Redis </br>
 **/


@Component
public class RedisPool implements RedisUtil {

    private static final Logger logger = LoggerFactory.getLogger(RedisPool.class);
    /**
     * redis配置对象类
     */
    private static RedisConfig redisConfig;


    private static JedisPool jedisPool;
    /**
     * 哨兵模式redis连接池
     */
    private static JedisSentinelPool jedisSentinelPool = null;

    /**
     * 哨兵模式
     */
    private final static String SENTINEL_MODE = "sentinel";
    /**
     * 普通模式
     */
    private final static String SINGLE_MODE = "single";

    static {
        logger.info("***********test for static code1!*******************");
//        logger.info("**********static code1- Host is " + redisConfig.getHost());
    }

    @Autowired(required = true)
    public void setRedisConfig(RedisConfig redisConfig) {
        RedisPool.redisConfig = redisConfig;
    }

    static {
        logger.info("***********test for static code2!*******************");
        if (redisConfig == null) {
            logger.info("*******static code2-redisConfig is null!********");
        } else {
            logger.info("**********static code2- Host is " + redisConfig.getHost() + "*****************");
        }
    }

    private synchronized static void initRedisConnection() {
        if (jedisSentinelPool == null && jedisPool == null) {
            logger.info("*****************************begin to init RedisConnection!*******************************");
            try {
                if (SENTINEL_MODE.equals(redisConfig.getMode())) {
                    logger.info("*************************sentinel_mode****************************");
                    Set<String> sentinels = new HashSet<String>();
                    String ips = redisConfig.getHost();
                    String ports = String.valueOf(redisConfig.getPort());
                    String[] ipArray = ips.split(",");
                    String[] portArray = ports.split(",");
                    for (int i = 0; i < ipArray.length; i++) {
                        HostAndPort hostAndPort = new HostAndPort(ipArray[i], Integer.parseInt(portArray[i]));
                        sentinels.add(hostAndPort.toString());
                    }
                    // 创建JedisSentinelPool对象
                    jedisSentinelPool = new JedisSentinelPool(redisConfig.getMaster(), sentinels);
                } else {
                    logger.info("*************************single_mode****************************");
                    // 创建jedis池配置实例
                    JedisPoolConfig config = new JedisPoolConfig();
                    //连接耗尽时是否阻塞, false报异常,true阻塞直到超时, 默认true
                    config.setBlockWhenExhausted(true);
                    //设置的逐出策略类名, 默认DefaultEvictionPolicy(当连接超过最大空闲时间,或连接数超过最大空闲连接数)
                    config.setEvictionPolicyClassName("org.apache.commons.pool2.impl.DefaultEvictionPolicy");
                    //是否启用pool的jmx管理功能, 默认true
                    config.setJmxEnabled(true);
                    //MBean ObjectName = new ObjectName("org.apache.commons.pool2:type=GenericObjectPool,name=" + "pool" + i); 默 认为"pool", JMX不熟,具体不知道是干啥的...默认就好.
                    config.setJmxNamePrefix("pool");
                    //是否启用后进先出, 默认true
                    config.setLifo(true);
                    //最大空闲连接数, 默认8个
                    config.setMaxIdle(redisConfig.getMaxIdle());
                    //最大连接数, 默认8个
                    config.setMaxTotal(redisConfig.getMaxActive());
                    //获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,  默认-1
                    config.setMaxWaitMillis(30 * 1000);
                    //逐出连接的最小空闲时间 默认1800000毫秒(30分钟)
                    config.setMinEvictableIdleTimeMillis(1800000);
                    //最小空闲连接数, 默认0
                    config.setMinIdle(0);
                    //每次逐出检查时 逐出的最大数目 如果为负数就是 : 1/abs(n), 默认3
                    config.setNumTestsPerEvictionRun(3);
                    //对象空闲多久后逐出, 当空闲时间>该值 且 空闲连接>最大空闲数 时直接逐出,不再根据MinEvictableIdleTimeMillis判断  (默认逐出策略)
                    config.setSoftMinEvictableIdleTimeMillis(3 * 60 * 1000);
                    //在获取连接的时候检查有效性, 默认false
                    config.setTestOnBorrow(false);
                    //在空闲时检查有效性, 默认false
                    config.setTestWhileIdle(false);
                    //逐出扫描的时间间隔(毫秒) 如果为负数,则不运行逐出线程, 默认-1
                    config.setTimeBetweenEvictionRunsMillis(-1);
                    //根据配置实例化jedis池
                    jedisPool = new JedisPool(config, redisConfig.getHost(), redisConfig.getPort(), 100000, redisConfig.getPassword());
                }
            } catch (Exception e) {
                logger.warn("connect redis failed.", e);
                throw new JedisException(e.getMessage());
            }
        }
    }

    @Override
    public String set(String key, String value) {
        initRedisConnection();
        Jedis jedis = jedisPool.getResource();
        String result = jedis.set(key, value);
        jedis.close();
        return result;
    }

    @Override
    public String get(String key) {
        initRedisConnection();
        Jedis jedis = jedisPool.getResource();
        String result = jedis.get(key);
        jedis.close();
        return result;
    }

    @Override
    public Boolean exists(String key) {
        initRedisConnection();
        Jedis jedis = jedisPool.getResource();
        Boolean result = jedis.exists(key);
        jedis.close();
        return result;
    }

    @Override
    public Long expire(String key, int seconds) {
        initRedisConnection();
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.expire(key, seconds);
        jedis.close();
        return result;
    }

    @Override
    public Long ttl(String key) {
        initRedisConnection();
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.ttl(key);
        jedis.close();
        return result;
    }

    @Override
    public Long incr(String key) {
        initRedisConnection();
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.incr(key);
        jedis.close();
        return result;
    }

    @Override
    public Long hset(String key, String field, String value) {
        initRedisConnection();
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.hset(key, field, value);
        jedis.close();
        return result;
    }

    @Override
    public String hget(String key, String field) {
        initRedisConnection();
        Jedis jedis = jedisPool.getResource();
        String result = jedis.hget(key, field);
        jedis.close();
        return result;
    }

    @Override
    public Long hdel(String key, String... field) {
        initRedisConnection();
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.hdel(key, field);
        jedis.close();
        return result;
    }
}
