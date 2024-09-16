package com.xxx.service_b.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloBController {
    @GetMapping
    public String hello(){
        return "hello B";
    }
}
