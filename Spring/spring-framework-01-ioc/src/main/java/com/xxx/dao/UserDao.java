package com.xxx.dao;

import com.xxx.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

//@Component("userDao1")
@Repository("userDao1")
public class UserDao {
    public ArrayList<User> findAll() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("张三", 20));
        users.add(new User("李四", 23));
        users.add(new User("王五", 16));
        users.add(new User("曹操", 32));
        users.add(new User("董卓", 42));
        return users;
    }
}

