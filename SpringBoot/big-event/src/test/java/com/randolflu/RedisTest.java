package com.randolflu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate redisTemplate;
    @Test
    public void get(){
        ValueOperations<String, String> redis = redisTemplate.opsForValue();
        String name = redis.get("name");
        System.out.println(name);
    }

    @Test
    public void set(){
        ValueOperations<String, String> redis = redisTemplate.opsForValue();
        redis.set("name","zhangsan");
        redis.set("password","123456",20, TimeUnit.SECONDS);


    }

}
