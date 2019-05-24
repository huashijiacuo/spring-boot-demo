package com.example.shi.demoweb.controller;

import com.example.shi.demoweb.entity.User;
import com.example.shi.demoweb.services.IUserService;
import com.example.shi.demoweb.vo.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @title: UserController </br>
 * @createDate: 2019/5/4 0:27 </br>
 * @author: shihsh  </br>
 * @description: 用户Controller </br>
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
    * @return: com.example.shi.demoweb.entity.User
    * @author: shihsh
    * @date: 2019/5/5
    */
    @PostMapping("/userInfo")
    public User getUserByParam(@RequestParam(value = "userName") String userName) {
        return userService.getUser(userName);
    }

    /**
    *
    * @description: 传递参数方式2：将json参数放在请求Body中,后端通过RequestBody注解，将参数绑定到对应的VO
    * @param: userVO
    * @return: com.example.shi.demoweb.entity.User
    * @author: shihsh
    * @date: 2019/5/5
    */
    @PostMapping("/userInfoByJson")
    public User getUserByJson(@RequestBody UserVO userVO) {
        return userService.getUser(userVO.getName());
    }

    @PostMapping("/userUpdate")
    public void updateUser(User user) {
        userService.updateUser(user);
    }

    @PostMapping("/userData")
    public boolean addUser(@RequestBody UserVO userVO) {
        userService.addUserToRedis(userVO);
        return true;
    }
}
