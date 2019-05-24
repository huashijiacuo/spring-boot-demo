package com.example.shi.demoweb.services;

import com.example.shi.demoweb.entity.User;
import com.example.shi.demoweb.vo.user.UserVO;

/**
 * @title: IUserService </br>
 * @createDate: 2019/5/3 22:21 </br>
 * @author: shihsh  </br>
 * @description: UserService 接口类 </br>
 * @version: V1.0
 **/


public interface IUserService {


    User getUser(String userName);


    void updateUser(User user);

    boolean addUserToRedis(UserVO userVO);
}
