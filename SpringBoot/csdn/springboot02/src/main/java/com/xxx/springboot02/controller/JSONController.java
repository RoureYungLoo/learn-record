package com.xxx.springboot02.controller;

import com.xxx.springboot02.entity.User;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/json")
public class JSONController {

    @GetMapping("/user")
    public User getUser() {
        return new User(1L, "张三", DigestUtils.md5DigestAsHex("123456".getBytes(StandardCharsets.UTF_8)));
    }

    @GetMapping("/users")
    public List<User> listUsers() {
        List<User> users = new ArrayList<>();
        User user1 = new User(1L, "张三", "123456");
        User user2 = new User(2L, "李四", "123456");
        User user3 = new User(3L, "王五", "123456");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        return users;
    }

    @GetMapping("/map")
    public Map<String, Object> mapUsers() {
        Map<String, Object> map = new HashMap<>();
        map.put("userInfo", new User(4L, "曹操", "123456"));
        map.put("blogAddr", "https://www.csdn.com/caocao");
        map.put("addr", "shanghai");
        map.put("hobby", null);
        map.put("token", null);
        return map;
    }
}
