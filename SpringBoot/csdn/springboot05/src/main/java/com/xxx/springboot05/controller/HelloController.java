package com.xxx.springboot05.controller;

import com.xxx.springboot05.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public String hello() {
        return "hello controller";
    }

    //    @GetMapping("/{var}")
//    @GetMapping("/{var}/test")
    @GetMapping("/{var}/test/{uname}")
    public String hello2(
            @PathVariable("var") String param,
            @PathVariable("uname") String username) {
        return "请求路径参数param：" + param + "\n" + "username: " + username;
    }

    @GetMapping("/register")
    public String hello3(Integer id, String uname, @RequestParam("password") String pwd) {
        return "" + id + "\n" + uname + "\n" + pwd;
    }

    @GetMapping("/user")
    public User hello4(User user){
        return user;
    }

    @PostMapping("/user/add")
    public User add(@RequestBody User user){
        return user;
    }

}
