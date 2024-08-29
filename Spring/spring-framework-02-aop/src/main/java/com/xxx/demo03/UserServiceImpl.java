package com.xxx.demo03;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public String saveUser() {
        System.out.println("user service save");
        return null;
    }

    @Override
    public String updateUser() {
        System.out.println("user service update ");
        return "true";
    }
}
