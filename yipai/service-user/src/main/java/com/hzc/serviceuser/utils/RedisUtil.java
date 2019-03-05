package com.hzc.serviceuser.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author:zhao-baolin
 * @Description:
 * @Date:Created in 2018/6/28
 * @Modified By:
 */
@Component
public class RedisUtil {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void set(String name, String value) {
        redisTemplate.opsForValue().set(name, value);
    }

    public void set(String name, Object obj) {
        redisTemplate.opsForValue().set(name, JSON.toJSONString(obj));
    }


    /**
     * 设置有效期时间 默认秒
     *
     * @param name
     * @param value
     * @param expire
     */
    public void set(String name, String value, int expire) {
        redisTemplate.opsForValue().set(name, value, expire, TimeUnit.SECONDS);
    }

    /**
     * 设置有效期时间
     *
     * @param name
     * @param value
     * @param expire
     * @param timeUnit
     */
    public void set(String name, String value, int expire, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(name, value, expire, timeUnit);
    }

    public String get(String name) {
        return redisTemplate.opsForValue().get(name);
    }

    public Object getSet(String key) {
        ValueOperations<String, String> op = redisTemplate.opsForValue();
        return op.get(key);
    }


    /**
     * 增加步长
     *
     * @param name
     * @param value
     * @return
     */
    public String setInc(String name, Long value) {
        if (null != value && value > 0) {
            //步长增加
            redisTemplate.boundValueOps(name).increment(value);
        }
        return get(name);
    }

    /**
     * 减少步长
     *
     * @param name
     * @param value
     * @return
     */
    public String setDec(String name, Long value) {
        if (null != value && value < 0) {
            //步长减少
            redisTemplate.boundValueOps(name).increment(-value);
        }
        return get(name);
    }


    public void delete(String name) {
        redisTemplate.delete(name);
    }


    /**
     * 查询key是否存在
     *
     * @param name
     * @return
     */
    public boolean hasKey(String name) {
        return redisTemplate.hasKey(name);
    }

    /**
     * 发布消息
     *
     * @param channel
     * @param message
     */
    public void sendMsg(String channel, Object message) {
        redisTemplate.convertAndSend(channel, message);
    }
}
