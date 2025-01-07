package com.example.sentinel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class SentinelController {


    @GetMapping("/add")
    public String get() {
        return "add";
    }

    @GetMapping("/del")
    public String del() {
        return "del";
    }

    @GetMapping("/update")
    public String update() {
        return "update";
    }

    @GetMapping("/find")
    public String find() {
        return "find";
    }
}
