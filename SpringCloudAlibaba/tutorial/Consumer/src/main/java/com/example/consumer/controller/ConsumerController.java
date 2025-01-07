package com.example.consumer.controller;

import com.example.consumer.client.ProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ConsumerController {
    @Autowired
    private ProviderClient providerClient;

    @GetMapping("/invoke")
    public String invokeProduct(){
        String product = providerClient.product(21);
        return "调用消费者服务成功...调用结果："+product;
    }

}
