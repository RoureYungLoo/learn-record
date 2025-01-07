package com.example.springboot07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/thy")
public class HelloController {

    @GetMapping("/test1")
    public String test1() {
        System.out.println("access test1");
        return "index";
    }

    @GetMapping("/test2")
    public String test2() {
        System.out.println("access test2");
        int i = 1 / 0;
        return "index";
    }

}
