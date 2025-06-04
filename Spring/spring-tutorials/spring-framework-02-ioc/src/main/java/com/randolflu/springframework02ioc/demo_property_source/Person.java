package com.randolflu.springframework02ioc.demo_property_source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;


public class Person {

    @Autowired
    private Environment environment;

    @Value("${person.name:小明}")
    private String name;
    @Value("${person.age:29}")
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public void sayHello() {
        System.out.println(environment.getProperty("person.name") + " " +
                environment.getProperty("person.age"));
    }
}

