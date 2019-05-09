package com.example.shi.demoweb.controller;

import com.example.shi.demoweb.entity.User;
import com.example.shi.demoweb.services.IUserService;
import com.example.shi.demoweb.vo.user.UserVO;
import com.example.shi.demoweb.vo.user.query.UserQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @title: UserController </br>
 * @createDate: 2019/5/4 0:27 </br>
 * @author: shihsh  </br>
 * @description: TODO </br>
 * @version: V1.0
 **/

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private IUserService userService;

    /**
    *
    * @description: 传递参数方式1：把参数放在params中
    * @param: userName
    * @return: com.example.ding.demoweb.entity.User
    * @author: shihsh
    * @date: 2019/5/5
    */
    @PostMapping("/userInfo")
    public User getUserByParam(@RequestParam(value = "userName") String userName) {
        return userService.getUserByName(userName);
    }

    /**
    *
    * @description: 传递参数方式2：将json参数放在请求Body中,后端通过RequestBody注解，将参数绑定到对应的VO
    * @param: userVO
    * @return: com.example.ding.demoweb.entity.User
    * @author: shihsh
    * @date: 2019/5/5
    */
    @PostMapping("/userInfoByJson")
    public List<User> getUserByJson(@RequestBody UserQueryVO userQueryVO) {
        return userService.getUser(userQueryVO);
    }

    @PostMapping("/userInfoByJsonSelect")
    public List<User> getUserBySelect(@RequestBody UserQueryVO userQueryVO) {
        return userService.selectUser(userQueryVO);
    }

    @PostMapping("/userUpdate")
    public void updateUser(User user) {
        userService.updateUser(user);
    }
}
