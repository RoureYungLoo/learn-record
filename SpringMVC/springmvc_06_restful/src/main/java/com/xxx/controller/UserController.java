package com.xxx.controller;

import com.xxx.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    /* 保存操作 */
    @RequestMapping(value = "/users", method = {RequestMethod.POST})
    @ResponseBody
    public String save() {
        System.out.println("user save... ");
        return "{\"module\":\"user save\"}";
    }

    /* 删除操作 */
    @RequestMapping(value = "/users/{id}", method = {RequestMethod.DELETE})
    @ResponseBody
    public String delete(@PathVariable Integer id) {
        System.out.println("user delete... " + id);
        return "{\"module\":\"user delete\"}";
    }

    /* 更新操作 */
    @RequestMapping(value = "/users", method = {RequestMethod.PUT})
    @ResponseBody
    public String update(@RequestBody User user) {
        System.out.println("user update..." + user);
        return "{\"module\":\"user update\"}";
    }

    /* 查询操作 */
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getById(@PathVariable Integer id) {
        System.out.println("user getById..." + id);
        return "{\"module\":\"user getById\"}";
    }

    /* 查询所有操作 */
    @RequestMapping(value = "/users", method = {RequestMethod.GET})
    @ResponseBody
    public String getAll() {
        System.out.println("user getAll..");
        return "{\"module\":\"user getAll\"}";
    }


}
