package com.randolflu.springframework02ioc.components;

import org.springframework.stereotype.Controller;

//@Controller
@Controller(value = "orderController")
public class OrderController {
    private String name = "OrderController";

    @Override
    public String toString() {
        return "OrderController{" +
                "name='" + name + '\'' +
                '}';
    }
}
