package com.example.shi.demoweb.kafka;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.util.Map;
import java.util.Properties;

/**
 * @title: KafkaFactory </br>
 * @createDate: 2019/5/9 21:10 </br>
 * @author: shihsh  </br>
 * @description: TODO </br>
 * @version: V1.0
 **/


@Configurable
public class KafkaFactory<K, V> {

    private KafkaProperties properties;


    public static KafkaConsumer initKafkaConsummer() {

        Properties props = new Properties();
        props.put("bootstrap.servers","localhost:9092");
        props.put("group.id","test");
        props.put("enable.auto.commit","true");
        props.put("auto.commit.interval.ms","1000");
        props.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        return new KafkaConsumer<>(props);
    }

    public KafkaConsumer getConsumer() {
        // 难道只能手动设置参数？
//        Map map = properties.buildConsumerProperties();
//        KafkaConsumer consumer = new KafkaConsumer(properties.buildConsumerProperties());
//        return consumer;
        return null;
    }

}
