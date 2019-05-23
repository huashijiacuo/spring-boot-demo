package com.example.shi.demoweb.kafka.consumer;

import com.example.shi.demoweb.kafka.KafkaFactory;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @title: KafkaReceiverByConsumer </br>
 * @createDate: 2019/5/9 21:18 </br>
 * @author: shihsh  </br>
 * @description: TODO </br>
 * @version: V1.0
 **/


public class KafkaReceiverByConsumer {

    private KafkaConsumer<String, Object> kafkaConsumer = new KafkaFactory().getConsumer();

    public void getMessageFromKafka(List<String> topics, int num) {
        kafkaConsumer.subscribe(topics);
        while (true) {
            ConsumerRecords<String, Object> records = kafkaConsumer.poll(Duration.ofSeconds(2L));
            for (ConsumerRecord<String, Object> record : records){
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
            }
        }
    }

    public void start() {
        List<String> topics = new ArrayList<>();
        topics.add("test");
        getMessageFromKafka( topics, 10);
    }
}
