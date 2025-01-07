package org.example.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

    private final Log log = LogFactory.getLog(HelloController.class);

    @GetMapping
    public String hello(ModelMap model){
        model.addAttribute("msg","hello spring mvc");
        log.info("aaaaaaaaaaaaaaaa");
        return "hello";
    }
}
