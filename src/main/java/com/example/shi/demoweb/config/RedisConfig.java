package com.example.shi.demoweb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author shihsh  </br>
 * @version V1.0
 * @title RedisConfig </br>
 * @createDate 2019/5/24 9:39 </br>
 * @description 读取Redis相关的配置信息 </br>
 **/


@Configuration
public class RedisConfig {
    @Value("${spring.redis.host}")
    private  String host;

    @Value("${spring.redis.password}")
    private  String password;

    @Value("${spring.redis.port}")
    private  int port;

    @Value("${spring.redis.mode}")
    private String mode;

    @Value("${spring.redis.sentinel.master}")
    public  String master;

    @Value("${spring.redis.timeout}")
    private  int timeout;

    /**
     * 连接池最大连接数
     */
    @Value("${spring.redis.jedis.pool.max-active}")
    private int maxActive;

    /**
     * 连接池最大阻塞等待时间
     */
    @Value("${spring.redis.jedis.pool.max-wait}")
    private int maxWati;

    /**
     * 最大空闲连接数
     */
    @Value("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.jedis.pool.max-wait}")
    private long maxWaitMillis;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public long getMaxWaitMillis() {
        return maxWaitMillis;
    }

    public void setMaxWaitMillis(long maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }

    public int getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public int getMaxWati() {
        return maxWati;
    }

    public void setMaxWati(int maxWati) {
        this.maxWati = maxWati;
    }
}
