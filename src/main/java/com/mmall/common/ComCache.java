package com.mmall.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by Administrator on 2017/9/21.
 */
public class ComCache extends RedisCache implements ICache {
    private RedisTemplate redisTemplate;

    public void setRedisTemplate(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    public ComCache(RedisTemplate redisTemplate, long expiration){
        super("comon","common".getBytes(),redisTemplate, expiration);
        this.redisTemplate = redisTemplate;
    }



}
