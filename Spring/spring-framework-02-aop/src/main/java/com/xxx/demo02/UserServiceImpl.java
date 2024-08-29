package com.xxx.demo02;

import com.xxx.demo01.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("添加用户");
    }

    @Override
    public void delUser() {
        System.out.println("删除用户");
    }
}
