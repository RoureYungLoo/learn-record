package com.example.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.sentinel.domain.User;
import com.example.sentinel.handler.ResourceHandler;
import com.example.sentinel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping
    @SentinelResource(
            value = "findAllResource",
            blockHandler = "findAllBlockHandler",
            blockHandlerClass = {UserController.class}
    )
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping
    public boolean save(@RequestBody User users) {
        return userService.save(users);
    }

    /* 关联流控模式 */
    @GetMapping("/hello")
    @SentinelResource(
            value = "helloResource",
            blockHandler = "helloBlockHandler",
            blockHandlerClass = {UserController.class}
    )
    public String hello() {
        return "关联接口返回值";
    }

    public static List<User> findAllBlockHandler(BlockException ex) {
        System.out.println("!!!!!! 不好意思，前方拥挤，请您稍后再试 ");
        return null;
    }

    public static String helloBlockHandler(BlockException ex) {
        return "不好意思，前方拥挤，请您稍后再试";
    }

    /* 熔断规则 */
    @GetMapping("/rongduan")
    @SentinelResource(
            value = "ruleResource",
            fallback = "ruleHandler",
            fallbackClass = {ResourceHandler.class}
    )
    public String rule() {
        try {
            Thread.sleep(new Random().nextLong(500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("熔断规则测试");
        return "熔断规则测试";
    }

    /* 热点规则 */
    @GetMapping("/hotrule")
    @SentinelResource(
            value = "hotRuleResource",
            blockHandler = "hotRuleHandler",
            blockHandlerClass = {ResourceHandler.class}
    )
    public String hotRule(
            @RequestParam(value = "userId", required = false) String userId,
            @RequestParam(value = "shopId", required = false) String shopId
    ) {
        System.out.println("========== hot rule test ===============");
        return "热点规则测试";
    }


}
