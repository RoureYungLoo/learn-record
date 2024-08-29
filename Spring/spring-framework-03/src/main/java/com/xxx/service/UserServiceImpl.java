package com.xxx.service;

import com.xxx.dao.UserDao;
import com.xxx.dao.UserDaoImpl;
import com.xxx.dao.UserDaoMysqlImpl;
import com.xxx.dao.UserDaoOracleImpl;

public class UserServiceImpl implements UserService{

    // private UserDao userDao = new UserDaoImpl();

    // private UserDao userDao = new UserDaoMysqlImpl();

    // private UserDao userDao = new UserDaoOracleImpl();

    private UserDao userDao;

    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public void findUser() {
        userDao.findUser();
    }
}
