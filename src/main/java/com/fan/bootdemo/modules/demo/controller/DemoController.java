package com.fan.bootdemo.modules.demo.controller;

import com.fan.bootdemo.modules.demo.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/demo")
public class DemoController {

    //日志记录器
    Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    DemoService demoService;

    @RequestMapping("/hello")
    public String hello() {
        return "hello,this is a springboot demo";
    }

    @RequestMapping("/greet")
    public ModelAndView test(ModelAndView mv) {
        mv.setViewName("/greet");
        mv.addObject("title", "欢迎使用Thymeleaf!");
        return mv;
    }


    @RequestMapping("/getdemo")
    public String getDemo() {
        logger.debug("debug:");
        logger.trace("trace:");
        logger.info("info:");
        return demoService.getDemo().toString();
    }

}
