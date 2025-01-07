package com.example.openfeign.consumer.controller;


import com.example.openfeign.consumer.feign.OrderClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class HelloB {
    @GetMapping
    public String hello() {
        return "Hello B";
    }


    @Autowired
    private OrderClientFeign orderClientFeign;


    @GetMapping("/get")
    public String getOrderNo(String orderNo) {
        String s = orderClientFeign.getOrderNo(orderNo);
        return s;
    }
}

