package com.fan.bootdemo.modules.demo.mapper;

import com.fan.bootdemo.modules.demo.entity.Demo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Mapper
public interface DemoMapper {
    //@Select("select * from user where id = 3")
     Demo getDemo();
}
