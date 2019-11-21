package com.jk.redisroad.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisClient {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /*设置当前的key以及value值*/
    public void setKeyStringValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 设置当前的key以及value值并且设置过期时间
     *
     * @param key
     * @param value
     * @param timeout  时间数量
     * @param timeUnit 时间单位
     */
    public void setKeyStringValueTimout(String key, String value, long timeout, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
    }

    /**
     * 设置key - Value , 并默认过期时间为5分钟
     *
     * @param key
     * @param value
     * @return
     */
    public void setKeyStringValueDefaultTimout(String key, String value) {
        setKeyStringValueTimout(key, value, 5, TimeUnit.MINUTES);
    }

    /**
     * 设置 key 的过期时间
     *
     * @param key
     * @param timeout
     * @param unit
     * @return
     */
    public Boolean setTimoutByKey(String key, long timeout, TimeUnit unit) {
        return redisTemplate.expire(key, timeout, unit);
    }


    /*有则取出key值所对应的值*/
    public String getKeyStringValue(String key) {
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        Object result = valueOperations.get(key);
        return (String) redisTemplate.opsForValue().get(key);
    }

    /*修改redis中key的名称*/
    public void renameKey(String oldKey, String newKey) {
        redisTemplate.rename(oldKey, newKey);
    }

    /**
     * 删除单个key值
     *
     * @param key
     * @return
     */
    public Boolean delByKey(String key) {
        return redisTemplate.delete(key);
    }


}
