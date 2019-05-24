package com.example.shi.demoweb.services.impl;

import com.alibaba.fastjson.JSON;
import com.example.shi.demoweb.config.RedisPool;
import com.example.shi.demoweb.entity.User;
import com.example.shi.demoweb.mapper.UserMapper;
import com.example.shi.demoweb.services.IUserService;
import com.example.shi.demoweb.vo.user.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @title: HelloWorldServiceImpl </br>
 * @createDate: 2019/5/3 22:20 </br>
 * @author: shihsh  </br>
 * @description: UserService实现类 </br>
 * @version: V1.0
 **/

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements IUserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Autowired
//    private UserDao userDao;

    @Autowired
    private UserMapper userMapper;

//    @Autowired
//    RedisTemplate redisTemplate;

//    @Autowired
//    StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisPool redisPool;

    @Override
    public User getUser(String userName) {
        logger.info("-------------------------get the user information by userName!--------------------------------");
//        User user = userDao.findUserByName(userName);
        User user = userMapper.findUserByName(userName);
        return user;
    }

    @Override
    public void updateUser(User user) {
//        userDao.updateUser(user.getId(), user.getName(), user.getAge(), user.getBirthday(), user.getId());
        userMapper.updateUser(user);
    }

    @Override
    public boolean addUserToRedis(UserVO userVO) {
/*        RedisPool redisPool = new RedisPool();
        String userStr = redisPool.hget(userVO.getName(),"USER");
        if (userStr == null || userStr.equals("")) {
            logger.info("redis中没有用户名为{}的用户", userVO.getName());
            redisPool.hset(userVO.getName(), "USER", JSON.toJSONString(userVO));
        } else {
            UserVO userVO1 = JSON.parseObject(userStr, UserVO.class);
            logger.info("redis中存在用户名为{}的用户，用户信息为:{}", userVO.getName(), userStr);

        }*/
//        redisTemplate.opsForHash().put("user", userVO.getName(), JSON.toJSONString(userVO)); //.leftPush("user:list", JSON.toJSONString(list));
//        stringRedisTemplate.opsForValue().set("user:name", "张三");
        redisPool.hset("USER",userVO.getName(),  JSON.toJSONString(userVO));
        return true;
    }
}
