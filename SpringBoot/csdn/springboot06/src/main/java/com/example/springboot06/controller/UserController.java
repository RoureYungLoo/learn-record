package com.example.springboot06.controller;

import com.example.springboot06.entity.User;
import com.example.springboot06.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Api(value = "用户接口文档")
public class UserController {

    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID查询用户")
    public User selectOne(
            @PathVariable("id")
            @ApiParam(value = "用户ID")
                    Long userId) {
        return new User(userId, "lisi", "123456");
    }

    @PostMapping
    @ApiOperation(value = "保存用户")
    public Result save(@RequestBody
                       @ApiParam(value = "用户JSON") User user) {
        System.out.println("save user: " + user);
        return Result.success();
    }
}
