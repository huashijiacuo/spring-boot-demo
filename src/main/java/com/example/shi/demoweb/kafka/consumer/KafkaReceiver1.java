package com.example.shi.demoweb.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @title: KafkaReceiver </br>
 * @createDate: 2019/5/7 22:00 </br>
 * @author: shihsh  </br>
 * @description: TODO </br>
 * @version: V1.0
 **/

@Component
public class KafkaReceiver1 {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Autowired
//    KafkaConsumer<String, Object> consumer;

    @KafkaListener(topics = {"test"})
    public void listen(ConsumerRecord<?, ?> record) {

        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            logger.info("Receiver2:----------------- record =" + record);
            logger.info("Receiver2:------------------ message =" + message);
        }

    }


}
