package com.randolflu.springframework03aop.aspectj2;

import org.springframework.stereotype.Component;

@Component
public class SpringHello implements Hello {
    @Override
    public String sayHello(StringBuffer words) {
        System.out.println("===SpringHello sayHello: " + words + "=======");
        return "Hello! " + words;
    }

    @Override
    public void say() {
        System.out.println("Hello Spring!");
    }
}
