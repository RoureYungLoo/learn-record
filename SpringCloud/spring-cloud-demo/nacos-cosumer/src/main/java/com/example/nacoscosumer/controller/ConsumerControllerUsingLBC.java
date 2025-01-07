package com.example.nacoscosumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/nacos/lbc")
public class ConsumerControllerUsingLBC {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/consumer")
    public String hello() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-provider");

        String url = serviceInstance.getUri().toString();

        RestTemplate restTemplate = new RestTemplate();

        String s = restTemplate.getForObject(url + "/nacos/provider", String.class);

        return s;

    }

}
