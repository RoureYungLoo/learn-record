package com.randolflu.reflection;

import java.io.Serializable;
import java.time.LocalDate;

public class User implements Serializable, Cloneable {
    private String name;
    protected Integer age;
    public Short gender;
    LocalDate birth;

    static {
        System.out.println(User.class.getName() + "静态块执行了");
    }

    public User(String name, Integer age, Short gender, LocalDate birth) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", birth=" + birth +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public User() {
    }

    @Override
    public User clone() {
        try {
            User clone = (User) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
