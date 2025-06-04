package com.randolflu.springframework03aop.aspectj;

import org.springframework.stereotype.Component;

@Component
public class HelloImpl implements Hello {
    @Override
    public String say(StringBuilder sb) {
        System.out.println("我是业务方法, 我正在执行业务");
//        throw new RuntimeException("模拟业务异常");
        String s = "";
        for (int i = 0; i < 50000; i++) {
            s += i;
        }
        return "hello " + sb;
    }
}
