package com.example.nacoscosumer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/nacos")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer")
    public String hello() {
        String url = "http://nacos-provider";
        String path = "/nacos/provider";
        String s = restTemplate.getForObject(url + path, String.class);
        return s;
    }
}
