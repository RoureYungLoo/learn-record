package com.example.zookeeperconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/lbc")
public class ConsumeUsingLBC {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/consume")
    public String consume() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("zookeeper-producer");
        String url = serviceInstance.getUri().toString() + "/provider/hello";
        System.out.println(url);
        RestTemplate restTemplate = new RestTemplate();
        String s = restTemplate.getForObject(url, String.class);
        return s;
    }
}
