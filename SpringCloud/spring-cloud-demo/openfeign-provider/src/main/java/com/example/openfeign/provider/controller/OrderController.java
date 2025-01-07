package com.example.openfeign.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/get")
    public String getOrderNo(String orderNo) {
        return "您查询的订单号：" + orderNo+"\n";
    }
}
