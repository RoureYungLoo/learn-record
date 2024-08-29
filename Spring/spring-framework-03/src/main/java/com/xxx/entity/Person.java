package com.xxx.entity;

/* 用于 P命名空间注入和C命名空间注入 */
public class Person {
    private String username;
    private int age;

    /* 无参构造函数 */
    public Person() {
    }

    /* 有参构造函数 */
    public Person(String username, int age) {
        this.username = username;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{ " +
                "username='" + username + '\'' +
                ", age=" + age +
                " }";
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
