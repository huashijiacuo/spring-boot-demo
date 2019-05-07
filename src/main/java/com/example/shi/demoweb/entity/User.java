package com.example.shi.demoweb.entity;

import java.util.Date;

/**
 * @title: User </br>
 * @createDate: 2019/5/4 0:23 </br>
 * @author: shihsh  </br>
 * @description: TODO </br>
 * @version: V1.0
 **/


public class User {

    private Long id;

    private String name;

    private Date birthday;

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }
}
