package com.example.shi.demoweb.task;

import com.example.shi.demoweb.entity.User;
import com.example.shi.demoweb.kafka.consumer.KafkaReceiver1;
import com.example.shi.demoweb.kafka.provider.KafkaSender1;
import com.example.shi.demoweb.kafka.provider.KafkaSender2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @title: KafkaTask </br>
 * @createDate: 2019/5/7 22:02 </br>
 * @author: shihsh  </br>
 * @description: TODO </br>
 * @version: V1.0
 **/

@Component
@Order(value = 100)
public class KafkaTask implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private KafkaSender1 kafkaSender1;

    @Autowired
    KafkaSender2<User> kafkaSender2;

    @Autowired
    private KafkaReceiver1 kafkaReceiver;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作<<<<<<<<<<<<<");
        new Thread() {
            @Override
            public void run() {
                //模拟发消息
                for (int i = 0; i < 5; i++) {

                    User user = new User();
                    user.setId(System.currentTimeMillis());
                    user.setName(UUID.randomUUID().toString());
                    user.setBirthday(new Date());

                    kafkaSender2.send(user);
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
             }
        }.start();

        new Thread() {
            @Override
            public void run() {
                int i = 0;
                while (true) {
                    kafkaSender1.send(Long.valueOf(i),"message" + i++);
                    try {
                        Thread.sleep(3000);
                    } catch (Exception e) {
                        logger.info("sleep failed!", e);
                    }
                }
            }
        }.start();

    }

}
