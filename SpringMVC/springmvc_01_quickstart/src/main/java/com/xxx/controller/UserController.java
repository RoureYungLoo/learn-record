package com.xxx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @RequestMapping(value = "/save")
/*    public void save(){
        System.out.println("user save ....");
    }*/
    @ResponseBody // 指定返回类型为JSON字符串
    public String save(){
        System.out.println("user save ....");
        return "{\"info\":\"springmvc\"}";
    }
}
