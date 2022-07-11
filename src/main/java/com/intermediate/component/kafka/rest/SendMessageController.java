package com.intermediate.component.kafka.rest;

import com.intermediate.component.kafka.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

//@RestController
public class SendMessageController {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    private final Producer producer;
    @Autowired
    SendMessageController(Producer producer){
        this.producer = producer;
    }


    @GetMapping("send/{message}")
    public void send(@PathVariable String message){
        this.kafkaTemplate.send("test",message);
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message")String message){
        this.producer.sendMessage(message);
    }
}
