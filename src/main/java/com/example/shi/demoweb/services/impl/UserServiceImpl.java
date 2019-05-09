package com.example.shi.demoweb.services.impl;

import com.example.shi.demoweb.entity.User;
import com.example.shi.demoweb.mapper.TkUserMapper;
import com.example.shi.demoweb.mapper.UserMapper;
import com.example.shi.demoweb.services.IUserService;
import com.example.shi.demoweb.vo.user.query.UserQueryVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

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

    @Autowired
    private TkUserMapper tkUserMapper;


    @Override
    public User getUserByName(String userName) {
        logger.info("-------------------------get the user information by userName!--------------------------------");
//        User user = userDao.findUserByName(userName);
        User user = userMapper.findUserByName(userName);
        return user;
    }

    @Override
    public List<User> getUser(UserQueryVO userQueryVO) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("name", userQueryVO.getUserName());
        example.createCriteria().andEqualTo("id", userQueryVO.getUserId());
        List<User> list = tkUserMapper.selectByExample(example);
        return list;
    }

    @Override
    public List<User> selectUser(UserQueryVO userQueryVO) {
        User user = new User();
        user.setName(userQueryVO.getUserName());
        return tkUserMapper.select(user);
    }

    @Override
    public void updateUser(User user) {
//        userDao.updateUser(user.getId(), user.getName(), user.getAge(), user.getBirthday(), user.getId());
        userMapper.updateUser(user);
    }
}
