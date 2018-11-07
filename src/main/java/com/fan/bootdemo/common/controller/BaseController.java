package com.fan.bootdemo.common.controller;

import com.alibaba.fastjson.JSON;
import com.fan.bootdemo.common.http.AppResponse;
import com.fan.bootdemo.common.http.ResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author   : Ershuai.Fan
 * Email    : 975068649@qq.com || ershuai.fan@gmail.com
 * Create at 2018/11/7
 * Description: baseController
 */
public class BaseController {

    /**
     * 日志对象
     */
    public Logger logger = LoggerFactory.getLogger(getClass());


    /**
     * App接口返回Response对象的JSON
     *
     * @param responseCode
     * @param errorMsg
     * @param t
     * @return
     */
    protected <T> String response(int responseCode, String errorMsg, T t) {
        return JSON.toJSONString(new AppResponse<T>(responseCode, errorMsg, t));
    }

    /**
     * App接口返回Response对象的JSON
     *
     * @param responseCode
     */
    protected <T> String response(int responseCode, T t) {
        return JSON.toJSONString(new AppResponse<T>(responseCode, t));
    }

    /**
     * App接口返回Response对象的JSON
     *
     * @param responseCode
     */
    protected <T> String response(int responseCode) {
        return JSON.toJSONString(new AppResponse<T>(responseCode));
    }


    @ExceptionHandler
    @ResponseBody
    protected String handleException(Exception e) {
        logger.info(e.getMessage());
        e.printStackTrace();
        if (e instanceof BadSqlGrammarException) {
            return response(ResponseCode.ERROR, "SQL语法错误！", "");
        } else {
            return response(ResponseCode.ERROR, e.getMessage(), "");
        }
    }
}
