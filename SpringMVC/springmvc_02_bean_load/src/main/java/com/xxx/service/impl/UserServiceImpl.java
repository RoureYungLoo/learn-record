package com.xxx.service.impl;

import com.xxx.domain.User;
import com.xxx.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void save(User user) {
        System.out.println("user service ...");
    }
}
