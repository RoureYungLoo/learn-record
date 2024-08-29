package com.xxx.entity;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Ball {
    @PostConstruct
    public void init() {
        System.out.println("--- init ball");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("--- destroy ball");
    }

    public void eat(){
        System.out.println("ball eating ···");
    }
}
