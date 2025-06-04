package com.randolflu.springframework03aop.aspectj2;

public class DefaultGoodBye implements GoodBye {
    @Override
    public String sayBye() {
//        System.out.println("DefaultGoodBye sayBye");
        return "Bye! ";
    }
}

