package com.intermediate.component.redis.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private RedisTemplate redisTemplate;


    @RequestMapping("/orderid")
    public Long order(){
        RedisAtomicLong redisAtomicLong = new RedisAtomicLong("test",redisTemplate.getConnectionFactory());

        return redisAtomicLong.getAndIncrement();
    }


}
