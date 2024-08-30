package com.randolflu.service;

import com.randolflu.pojo.User;

public interface UserService {
    User findByUserName(String username);

    int add(String username, String password);

    String login(String username, String password);

    User getUserInfo(String token);
}
