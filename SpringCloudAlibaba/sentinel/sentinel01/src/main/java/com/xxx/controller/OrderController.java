package com.xxx.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private UserService userService;

    @GetMapping
    @SentinelResource(
            value = "getOrderResource",
            blockHandler="blockHandlerForGetOrder",
            blockHandlerClass = OrderController.class)
    public String getOrderNo(){
        return userService.getOrderNo();
    }

    public static String blockHandlerForGetOrder(BlockException e){
//        System.out.println("访问被Block了");
        return "访问被Block了";
    }
}
