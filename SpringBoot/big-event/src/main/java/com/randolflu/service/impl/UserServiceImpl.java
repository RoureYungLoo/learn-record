package com.randolflu.service.impl;

import com.randolflu.mapper.UserMapper;
import com.randolflu.pojo.User;
import com.randolflu.service.UserService;
import com.randolflu.utils.EncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }


    public int add(String username, String password) {
        // 密码加密
        int row = userMapper.add(username, EncryptUtils.MD5(password));
        return row;
    }
}
