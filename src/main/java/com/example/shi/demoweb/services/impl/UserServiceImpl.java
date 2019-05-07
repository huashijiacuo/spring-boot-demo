package com.example.shi.demoweb.services.impl;

import com.example.shi.demoweb.entity.User;
import com.example.shi.demoweb.mapper.UserMapper;
import com.example.shi.demoweb.services.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @title: HelloWorldServiceImpl </br>
 * @createDate: 2019/5/3 22:20 </br>
 * @author: shihsh  </br>
 * @description: TODO </br>
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
}
