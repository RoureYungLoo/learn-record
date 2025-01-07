package com.xxx.springboot05.entity;

public class User {
    private Long id;
    private String uname;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public User(Long id, String uname, String password) {
        this.id = id;
        this.uname = uname;
        this.password = password;
    }
}

