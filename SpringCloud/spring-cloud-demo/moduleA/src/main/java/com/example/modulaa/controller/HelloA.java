package com.example.modulaa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloA {
    @GetMapping
    public String hello(){
        return "Hello A";
    }
}
