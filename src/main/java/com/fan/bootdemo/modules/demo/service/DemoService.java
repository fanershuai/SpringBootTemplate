package com.fan.bootdemo.modules.demo.service;

import com.fan.bootdemo.modules.demo.entity.Demo;
import com.fan.bootdemo.modules.demo.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @Autowired
    DemoMapper demoMapper;


    public Demo getDemo() {
        return demoMapper.getDemo();
    }
}
