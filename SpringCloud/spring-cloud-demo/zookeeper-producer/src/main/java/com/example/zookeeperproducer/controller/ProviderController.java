package com.example.zookeeperproducer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
@RefreshScope//开启属性更新功能，让这个bean里面的属性会根据配置中心的修改而同步
public class ProviderController {

    @Value("${msg:hello}")
    private String msg;


    @GetMapping("/hello")
    public String hello() {
//        return "Hello world zookeeper ,I am a provider.";
        return msg;
    }
}
