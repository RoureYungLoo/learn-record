package com.randolflu.mynovel.controller.front;

import com.randolflu.mynovel.core.common.resp.RestResp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public RestResp<String> hello(){
        return RestResp.ok("hello my novel");
    }
}
