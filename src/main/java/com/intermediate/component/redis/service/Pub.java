package com.intermediate.component.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

//@Service
public class Pub {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public void pubMessage(String channel,String message){
        redisTemplate.convertAndSend(channel,message);
    }
}
