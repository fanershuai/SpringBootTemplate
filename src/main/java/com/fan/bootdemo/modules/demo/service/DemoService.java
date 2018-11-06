package com.fan.bootdemo.modules.demo.service;

import com.fan.bootdemo.common.redis.RedisCacheUtil;
import com.fan.bootdemo.modules.demo.entity.Demo;
import com.fan.bootdemo.modules.demo.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.cache.interceptor.KeyGenerator;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class DemoService {

    @Resource
    DemoMapper demoMapper;

    @Autowired
    RedisCacheUtil redisCacheUtil;


    public Demo getDemo() {
        return demoMapper.getDemo();
    }

    @Transactional
    public void addUser() {
        demoMapper.addUser();
    }


    public void setKey(String key, String value) {
        redisCacheUtil.set(key, value);//1分钟过期
    }

    public String getValue(String key) {
        return redisCacheUtil.getValue(key);
    }

}
