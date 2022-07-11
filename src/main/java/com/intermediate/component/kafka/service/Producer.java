package com.intermediate.component.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

//@Service
public class Producer {
    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "users";
    private static final String TestTOPIC = "test";

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message){
        logger.info(String.format("#### -> producing message -> %s",message));
//        this.kafkaTemplate.send(TOPIC,message);
        this.kafkaTemplate.send(TestTOPIC,message);


        //transaction 1
        this.kafkaTemplate.executeInTransaction( t ->{

            return true;
        });
    }


}
