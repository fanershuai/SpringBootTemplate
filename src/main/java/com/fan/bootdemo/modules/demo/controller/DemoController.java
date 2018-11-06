package com.fan.bootdemo.modules.demo.controller;

import com.fan.bootdemo.modules.demo.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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


    @RequestMapping("/adduser")
    public String addUser() {
        demoService.addUser();
        return "ok";
    }

    @RequestMapping(value = "/setkey", method = RequestMethod.GET)
    public String setKey(@RequestParam(value = "key", required = false, defaultValue = "keydefault") String key, @RequestParam(value = "value", required = false, defaultValue = "valuedefault") String value) {
        demoService.setKey(key, value);
        return "ok";
    }

    @RequestMapping(value = "/getvalue/{key}")
    public String getvalue(@PathVariable("key") String key) {

        return demoService.getValue(key);
    }

}
