package com.example.shi.demoweb.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @title: KafkaReceiver2 </br>
 * @createDate: 2019/5/8 10:19 </br>
 * @author: shihsh  </br>
 * @description: TODO </br>
 * @version: V1.0
 **/


@Component
public class KafkaReceiver2 {

    private Logger logger = LoggerFactory.getLogger(KafkaReceiver2.class);

    /**
     * 监听kafka.tut 的 topic
     *
     * @param record record
     * @param topic  topic
     */
    @KafkaListener(id = "tut", topics = "kafka.tut")
    public void listen(ConsumerRecord<?, ?> record, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        //判断是否NULL
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {
            //获取消息
            Object message = kafkaMessage.get();

            logger.info("Receive2： +++++++++++++++ Topic:" + topic);
            logger.info("Receive2： +++++++++++++++ Record:" + record);
            logger.info("Receive2： +++++++++++++++ Message:" + message);
        }
    }
}
