package com.randolflu.springframework02ioc.entity;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Random;

public class User {
    private String who;
    private int age;

    public String getWho() {
        return who;
    }

    // @PostConstruct
    public void postConstruct() {
        this.who = "kitty";
        this.age = new Random().nextInt(120);
        System.out.println(getClass().getTypeName()+": === postConstruct");
    }

   //  @PreDestroy
    public void preDestroy() {
        System.out.println(getClass().getTypeName()+": === preDestroy");
        System.out.println(this.getClass().getTypeName() + "@" + this.hashCode() + "is ready to be destroyed.");
    }

    @Override
    public String toString() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "User{" +
                "age=" + age +
                ", who='" + who + '\'' +
                '}';
    }

    public void setWho(String who) {
        this.who = who;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User() {
    }

    public User(String who, int age) {
        this.who = who;
        this.age = age;
    }


}
