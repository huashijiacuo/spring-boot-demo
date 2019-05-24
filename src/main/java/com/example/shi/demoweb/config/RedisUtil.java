package com.example.shi.demoweb.config;

/**
 * @author shihsh  </br>
 * @version V1.0
 * @title RedisUtil </br>
 * @createDate 2019/5/23 22:23 </br>
 * @description Redis操作接口类 </br>
 **/


public interface RedisUtil {

    String set(String key, String value);

    String get(String key);

    Boolean exists(String key);

    Long expire(String key, int seconds);

    Long ttl(String key);

    Long incr(String key);

    Long hset(String key, String field, String value);

    String hget(String key, String field);

    Long hdel(String key, String... field);
}
