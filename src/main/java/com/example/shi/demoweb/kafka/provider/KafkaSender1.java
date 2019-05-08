package com.example.shi.demoweb.kafka.provider;

import com.example.shi.demoweb.kafka.bean.Message;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @title: KafkaSender </br>
 * @createDate: 2019/5/7 22:01 </br>
 * @author: shihsh  </br>
 * @description: TODO </br>
 * @version: V1.0
 **/

@Component
public class KafkaSender1 {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;


    private Gson gson = new GsonBuilder().create();

    //发送消息方法
    public void send(Long id, String msg) {
        Message message = new Message();
        message.setId(id);
        message.setMessage("-----------------------This is the test message! " + msg + " ----------------------");
        message.setTimestamp(new Date());
        logger.info("Sender: +++++++++++++++++++++  message = {}+++++++++++++++++++", gson.toJson(message));
        kafkaTemplate.send("test", gson.toJson(message));
    }
}
