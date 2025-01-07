package com.example.sentinel.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Component;

@Component
public class ResourceHandler {

    public static String ruleHandler(Throwable throwable) {
        System.out.println("触发熔断，服务不可用");
        return "触发熔断，服务不可用";
    }

    public static String hotRuleHandler(String userId, String shopId, BlockException ex) {
        System.out.println("访问过于频繁，触发热点数据限流");
        return "访问过于频繁，触发热点数据限流";
    }
}
