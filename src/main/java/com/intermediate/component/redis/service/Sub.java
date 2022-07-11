package com.intermediate.component.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

//@Component("sub")
public class Sub implements MessageListener {
    @Autowired
    private GenericJackson2JsonRedisSerializer jackson2JsonRedisSerializer;
    @Autowired
    private StringRedisSerializer stringRedisSerializer;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        byte[] body = message.getBody();
//        byte[] channel =
    }
}
