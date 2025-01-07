package com.example.springboot07.controller;

import com.example.springboot07.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{id}")
    public String selectOne(@PathVariable("id") Long userId, Model model) {
        User user = new User(10001L, "zhangsan", "123456");
        model.addAttribute("user", user);
        return "users/list";
    }

    @GetMapping
    public String selectList(Model model){
        User user = new User(10001L, "zhangsan", "123456");
        model.addAttribute("user", user);

        List<User> list = new ArrayList<>();
        list.add(new User(10002L,"caocao","123312"));
        list.add(new User(10032L,"zhoayun","o2345hu"));
        list.add(new User(10004L,"guanyu","sgdf234"));
        list.add(new User(10005L,"yuanshao","ewf523"));

        model.addAttribute("list",list);
        return "users/list";
    }
}
