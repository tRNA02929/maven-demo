package com.ksyun.libo.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class NetCutApiDTO {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Cacheable(value = "text", key = "#key")
    public String getText(String key) {
        String text = stringRedisTemplate.opsForValue().get(key);
        if (text == null)
            return "";
        return text;
    }

    @CachePut(value = "text", key = "#key")
    public String postText(String key, String upload) {
        stringRedisTemplate.opsForValue().set(key, upload);
        return upload;
    }
}
