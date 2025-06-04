package com.randolflu.springframework03aop.aspectj2;

import org.aspectj.lang.annotation.Pointcut;

public class HelloPointcut {
    @Pointcut("target(com.randolflu.springframework03aop.aspectj2.Hello)")
    public void helloType() {
    }

    @Pointcut("execution(public * say())")
    public void sayOption() {
    }

    @Pointcut("helloType()&&sayOption()")
    public void sayHello() {
    }
}
