package com.example.shi.demoweb.vo.user.query;

import java.util.Date;

/**
 * @title: UserQueryVO </br>
 * @createDate: 2019/5/9 10:07 </br>
 * @author: shihsh  </br>
 * @description: User查询VO </br>
 * @version: V1.0
 **/


public class UserQueryVO {

    private Long userId;

    private String userName;

    private Date birthday;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
