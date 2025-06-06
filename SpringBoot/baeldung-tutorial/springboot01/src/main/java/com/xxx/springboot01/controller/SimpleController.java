package com.xxx.springboot01.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SimpleController {

    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/")
    public String homePage(Model m) {
        m.addAttribute("appName",appName);
        return "home";
    }
}
