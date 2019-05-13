package com.arquitectura.kafkabroker.listener;

import com.arquitectura.kafkabroker.models.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "test", groupId = "group_id")
    public User consume(User userMessage){

        System.out.println("Mensaje consumido: "+ userMessage);
    }
}
