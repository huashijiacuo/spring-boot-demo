package com.example.shi.demoweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@SpringBootApplication
// 注解MapperScan表示动态扫描DAO接口所在包
//@MapperScan("com.example.shi.demoweb.dao")
@MapperScan("com.example.shi.demoweb.mapper") // mybatis扫描路径，针对的是接口Mapper类
public class DemoWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoWebApplication.class, args);
    }

}
