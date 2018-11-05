package com.fan.bootdemo.modules.demo.service;

import com.fan.bootdemo.modules.demo.entity.Demo;
import com.fan.bootdemo.modules.demo.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class DemoService {

    @Resource
    DemoMapper demoMapper;

    @Autowired
    private StringRedisTemplate template;


    public Demo getDemo() {
        return demoMapper.getDemo();
    }

    public void addUser() {
        demoMapper.addUser();
    }

    public void  setKey(String key,String value){
        ValueOperations<String, String> ops = template.opsForValue();
        ops.set(key,value,2, TimeUnit.MINUTES);//1分钟过期
    }

    public String getValue(String key){
        ValueOperations<String, String> ops = this.template.opsForValue();
        return ops.get(key);
    }

}
