package com.example.nacosprovider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nacos")
public class ProviderController {

    @GetMapping("/provider")
    public String hello(){
        return "hello from nacos provider\n";
    }
}
