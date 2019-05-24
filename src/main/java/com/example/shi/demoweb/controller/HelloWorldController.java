package com.example.shi.demoweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @title: HelloWorldController </br>
 * @createDate: 2019/5/3 22:19 </br>
 * @author: shihsh  </br>
 * @description: 测试用，硬编码mysql配置 </br>
 * @version: V1.0
 **/


@RestController
@RequestMapping(value = "/index")
public class HelloWorldController {


    /**
    *
    * @description: get方式，访问
    * @param:
    * @return: java.lang.String
    * @author: shihsh
    * @date: 2019/5/5
    */
    @GetMapping(value = "hello")
    public String sayHello() {
        return "Hello World!";
    }


    /**
    *
    * @description: 测试数据连接
    * @param:
    * @return: java.lang.String
    * @author: shihsh
    * @date: 2019/5/5
    */
    @PostMapping(value = "hello")
    public String getHello() {
        String result = "false!";
        Connection conn = null;
        String sql;
        // MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
        // 避免中文乱码要指定useUnicode和characterEncoding
        // 执行数据库操作之前要在数据库管理系统上创建一个数据库，名字自己定，
        // 下面语句之前就要先创建javademo数据库
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("成功加载MySQL驱动程序");
            // 一个Connection代表一个数据库连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web-test?useSSL=false&serverTimezone=GMT", "root", "shun1qaz@WSX");
            System.out.println("创建数据表成功");
            result = "success!";
        } catch (Exception e) {
            e.printStackTrace();;
        }

        return "Hello World! " + result;
    }

    @GetMapping("/test")
    public String getTest() {
        return "Hello";
    }
}
