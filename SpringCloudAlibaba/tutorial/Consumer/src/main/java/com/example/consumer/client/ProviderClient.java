package com.example.consumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("PRODUCTS")
public interface ProviderClient {

    @RequestMapping("/product/{id}")
    public String product(@PathVariable("id") Integer id);
}
