package com.arquitectura.kafkabroker.controllers;

import com.arquitectura.kafkabroker.models.Response;
import com.arquitectura.kafkabroker.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kafka")
public class KafkaController {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    private static final String TOPIC = "test";
    User userFromTopic = null;

    @PostMapping("publish")
    public Response postMessage(@RequestBody final User user) {
        kafkaTemplate.send(TOPIC, user);
        Response response = new Response("Mensaje publicado correctamente",user);
        return response;
    }

    @GetMapping("consumer")
    @KafkaListener(topics = "test", groupId = "group_id")
    public Response consumeTopic(){
        Response response = new Response();
        response.setStatusMessage("Mensaje consumido correctamente");
        response.setMensaje(consumer());

        return response;
    }

    @KafkaListener(topics = "test", groupId = "group_id")
    public User consumer(User userMessage){
        userFromTopic = userMessage;
        return userFromTopic;
    }
}
