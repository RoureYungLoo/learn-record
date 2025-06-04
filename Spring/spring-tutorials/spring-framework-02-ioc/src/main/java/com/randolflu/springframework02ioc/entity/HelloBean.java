package com.randolflu.springframework02ioc.entity;


import javax.annotation.PostConstruct;

public class HelloBean  {
    private String username;


    @PostConstruct
    public void postConstruct() {
        System.out.println("-- 调用 HelloBean 的 PostConstruct ");
        System.out.println();
    }
}
