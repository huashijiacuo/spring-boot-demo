package com.example.shi.demoweb.kafka.consumer;

import com.example.shi.demoweb.kafka.bean.Message;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

/**
 * @title: KafkaReceiver </br>
 * @createDate: 2019/5/7 22:00 </br>
 * @author: shihsh  </br>
 * @description: TODO </br>
 * @version: V1.0
 **/

@Component
public class KafkaReceiver {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @KafkaListener(topics = {"test"})
    public void listen(ConsumerRecord<?, ?> record) {

        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            logger.info("Receiver:----------------- record =" + record);
            logger.info("Receiver:------------------ message =" + message);
        }

    }
}
