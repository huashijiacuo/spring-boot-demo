package com.example.shi.demoweb.vo.user;

import java.util.Date;

/**
 * @title: UserVO </br>
 * @createDate: 2019/5/5 14:05 </br>
 * @author: shihsh  </br>
 * @description: TODO </br>
 * @version: V1.0
 **/


public class UserVO {
    private Long id;

    private String name;

    private Date date;

    private Byte age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }
}
