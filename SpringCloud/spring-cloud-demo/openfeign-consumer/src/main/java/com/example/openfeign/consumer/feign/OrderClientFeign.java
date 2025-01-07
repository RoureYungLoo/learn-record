package com.example.openfeign.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@FeignClient(value = "provider")
public interface OrderClientFeign {


    @GetMapping("/order/get")
    public String getOrderNo(@RequestParam(value = "orderNo") String orderNo);

}
