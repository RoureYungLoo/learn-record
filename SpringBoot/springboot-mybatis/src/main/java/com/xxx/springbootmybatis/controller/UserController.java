package com.xxx.springbootmybatis.controller;

import com.xxx.springbootmybatis.pojo.User;
import com.xxx.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

//    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
//    @GetMapping("/{id}")
    @RequestMapping(value = "/{userid}", method = {RequestMethod.GET})
    @GetMapping("/{userid}")
    public User findById(@PathVariable("userid") int id) {
        return userService.findById(id);
    }
}
