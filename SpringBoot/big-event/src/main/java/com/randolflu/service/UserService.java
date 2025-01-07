package com.randolflu.service;

import com.randolflu.pojo.User;

import java.util.Map;

public interface UserService {
    User findByUserName(String username);

    int add(String username, String password);

    String login(String username, String password);

    User getUserInfo(String token);

    boolean update(User user);

    void updateAvatar(String avatarUrl);

    boolean updatePwd(Map<String, String> newPwd);
}
