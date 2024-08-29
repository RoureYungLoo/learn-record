package com.xxx.springbootmybatis.service.impl;

import com.xxx.springbootmybatis.mapper.UserMapper;
import com.xxx.springbootmybatis.pojo.User;
import com.xxx.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(int id) {
        return userMapper.findById(id);
    }
}
