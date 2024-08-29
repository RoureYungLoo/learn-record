package com.xxx.entity;

public class Teacher {
    private Dog dog;
    private Pig pig;
    private String str;

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public void setPig(Pig pig) {
        this.pig = pig;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Dog getDog() {
        return dog;
    }

    public Pig getPig() {
        return pig;
    }

    public String getStr() {
        return str;
    }
}
