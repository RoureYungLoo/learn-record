package com.randolflu.springframework03aop.aspect4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;


import java.lang.reflect.Method;

public class CustomThrowAdvice implements ThrowsAdvice {
    public static final Logger logger = LoggerFactory.getLogger(CustomThrowAdvice.class);

    // 处理所有类型的异常
    public void afterThrowing(Exception ex) {
        logger.info("【全局异常捕获】发生异常: " + ex.getMessage());
        // 这里可以添加日志记录、告警等逻辑
    }

    // 处理特定类型的异常（示例：处理NullPointerException）
    public void afterThrowing(NullPointerException ex) {
        logger.info("【空指针异常】详细信息: " + ex.getMessage());
        // 特殊处理逻辑
    }

    // 完整参数版本（可获取方法信息）
    public void afterThrowing(Method method, Object[] args, Object target, RuntimeException ex) {
        logger.info("【方法异常】方法名: " + method.getName());
        logger.info("【方法异常】参数数量: " + args.length);
        logger.info("【方法异常】异常类型: " + ex.getClass().getSimpleName());
    }
}