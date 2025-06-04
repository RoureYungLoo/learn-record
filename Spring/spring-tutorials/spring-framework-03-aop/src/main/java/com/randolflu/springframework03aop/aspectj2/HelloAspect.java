package com.randolflu.springframework03aop.aspectj2;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
//@Order(1)
public class HelloAspect {

    //    @Before("target(com.randolflu.springframework03aop.aspectj2.Hello)&&args(words)")
    public void doBefore(StringBuffer words) {
        words.append("Welcome to Spring! ");
    }

    public void doAfter() {
        System.out.println("doAfter");
    }

    public void doAround() {
        System.out.println("doAround");
    }

    public void doAfterReturn() {
        System.out.println("doAfterReturn");
    }

    public void doAfterThrow() {
        System.out.println("doAfterThrow");
    }

    public void addWords(StringBuffer words) {
        words.append("Welcome to Spring! ");
    }

}
