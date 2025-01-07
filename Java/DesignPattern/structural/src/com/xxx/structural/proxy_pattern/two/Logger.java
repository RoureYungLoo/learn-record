package com.xxx.structural.proxy_pattern.two;

public class Logger {
    public void Log(String userId) {

        System.out.println("--- 记录日志：用户" + userId + "查询次数+1，更新到数据库 ----");
        // 数据库操作
        // ....
    }
}
