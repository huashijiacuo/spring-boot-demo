package com.example.shi.demoweb.task;

import com.example.shi.demoweb.kafka.consumer.KafkaReceiver;
import com.example.shi.demoweb.kafka.provider.KafkaSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

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
    private KafkaSender kafkaSender;

    @Autowired
    private KafkaReceiver kafkaReceiver;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作<<<<<<<<<<<<<");
        new Thread() {
            @Override
            public void run() {
                int i = 0;
                while (true) {
                    kafkaSender.send(Long.valueOf(i),"message" + i++);
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
