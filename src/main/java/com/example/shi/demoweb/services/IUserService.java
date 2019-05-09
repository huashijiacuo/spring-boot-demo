package com.example.shi.demoweb.services;

import com.example.shi.demoweb.entity.User;
import com.example.shi.demoweb.vo.user.query.UserQueryVO;

import java.util.List;

/**
 * @title: IUserService </br>
 * @createDate: 2019/5/3 22:21 </br>
 * @author: shihsh  </br>
 * @description: UserService接口 </br>
 * @version: V1.0
 **/


public interface IUserService {


    User getUserByName(String userName);

    List<User> getUser(UserQueryVO userQueryVO);

     List<User> selectUser(UserQueryVO userQueryVO);

    void updateUser(User user);
}
