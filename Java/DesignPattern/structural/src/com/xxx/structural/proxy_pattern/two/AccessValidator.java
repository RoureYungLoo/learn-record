package com.xxx.structural.proxy_pattern.two;

public class AccessValidator {
    // 模拟验证
    public boolean Validate(String userId){
        System.out.println("--- 正在验证 ---");
        return userId.equals("zhangsan");
    }
}
