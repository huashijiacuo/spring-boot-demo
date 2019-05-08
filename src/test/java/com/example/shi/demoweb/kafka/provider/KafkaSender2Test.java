package com.example.shi.demoweb.kafka.provider;

import com.example.shi.demoweb.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaSender2Test {

    @Test
    public void send() {
        System.out.println("this is a test");
    }

    @Autowired
    private KafkaSender2<User> kafkaSender;

    @Test
    public void kafkaSender2Send() throws InterruptedException {
        //模拟发消息
        for (int i = 0; i < 5; i++) {

            User user = new User();
            user.setId(System.currentTimeMillis());
            user.setName(UUID.randomUUID().toString());
            user.setBirthday(new Date());

            kafkaSender.send(user);
            Thread.sleep(3000);

        }
    }
}