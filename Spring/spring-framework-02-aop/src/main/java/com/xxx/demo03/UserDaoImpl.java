package com.xxx.demo03;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
    @Override
    public boolean saveUser() {
        System.out.println("user dao save");
        return false;
    }

    @Override
    public boolean updateUser() {
        System.out.println("user dao update");
        return false;
    }
}
