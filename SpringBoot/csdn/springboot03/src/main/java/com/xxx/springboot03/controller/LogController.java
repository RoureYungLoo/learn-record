package com.xxx.springboot03.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogController {

    private final static Logger LOGGER = LoggerFactory.getLogger(LogController.class);

    @GetMapping
    public String log(){
        LOGGER.debug("=====测试日志 debug 级别打印====");
        LOGGER.info("=====测试日志 info 级别打印====");
        LOGGER.error("=====测试日志 error 级别打印====");
        LOGGER.warn("=====测试日志 warn 级别打印====");

        String message1 = "Warn message!";
        String message2 = "Debug message!";

        LOGGER.warn("------- 测试日志: {}, {}",message1,message2);
        return "success";
    }
}
