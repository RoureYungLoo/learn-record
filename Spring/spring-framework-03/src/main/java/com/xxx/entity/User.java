package com.xxx.entity;

public class User {
    private String address;
    private String hobby;

    /* 无参构造 */
    public User() {
        // System.out.println("调用无参构造"+this);
    }

    /* 有参构造 */
    public User(String address, String hobby) {
        this.address = address;
        this.hobby = hobby;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void show(){
        System.out.println(address+" "+hobby);
    }
}
