package com.example.moduleb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloB {
    @GetMapping
    public String hello(){
        return "Hello B";
    }
}

