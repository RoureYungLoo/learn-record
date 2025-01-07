package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/product/{id}")
    public String provide(@PathVariable("id") Integer id) {
        return "调用商品服务：" + id + ", 当前提供服务的端口：" + port;
    }
}
