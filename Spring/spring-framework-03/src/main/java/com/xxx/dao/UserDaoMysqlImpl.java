package com.xxx.dao;

public class UserDaoMysqlImpl implements UserDao{
    @Override
    public void findUser() {
        System.out.println("Mysql获取用户数据");
    }
}
