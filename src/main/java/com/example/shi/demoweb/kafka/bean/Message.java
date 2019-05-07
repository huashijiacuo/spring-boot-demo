package com.example.shi.demoweb.kafka.bean;

import java.util.Date;

/**
 * @title: Message </br>
 * @createDate: 2019/5/7 21:59 </br>
 * @author: shihsh  </br>
 * @description: TODO </br>
 * @version: V1.0
 **/


public class Message {

    private Long id;

    private String message;

    private Date timestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
