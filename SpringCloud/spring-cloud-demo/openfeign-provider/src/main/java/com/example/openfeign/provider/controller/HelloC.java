package com.example.openfeign.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloC {
    @GetMapping
    public String hello(){
        return "Hello C";
    }
}
