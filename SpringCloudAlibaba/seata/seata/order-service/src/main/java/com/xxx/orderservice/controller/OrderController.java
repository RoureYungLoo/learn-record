package com.xxx.orderservice.controller;

import com.xxx.orderservice.domain.CommonResult;
import com.xxx.orderservice.domain.Order;
import com.xxx.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/create")
    public CommonResult createOrder(Order order) {
        if (orderService.createOrder(order)){
            return new CommonResult<>(200,"订单创建成功");
        }
        return new CommonResult<>(500,"订单创建失败");
    }
}
