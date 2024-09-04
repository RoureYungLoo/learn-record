package com.randolflu.utils;


import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;


public class RedisUtil {

    private static StringRedisTemplate redisTemplate;

    public static String get(String key) {
        ValueOperations<String, String> redis = redisTemplate.opsForValue();
        return redis.get(key);
    }

    public static void set(String key, String value) {
        ValueOperations<String, String> redis = redisTemplate.opsForValue();
        redis.set(key, value);
    }

    public static String wrapKey(String... key) {
        String _key = "";
        for (int i = 0; i < key.length; i++) {
            _key = _key + key[i]+":";
        }
        return _key.substring(0,_key.length()-1);
    }

}
