package com.xxx.service;

import com.xxx.dao.UserDao;
import com.xxx.entity.User;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;

@Component("userService1")
public class UserService {

    /* IoC容器：依赖注入 */
    // @Resource
    @Resource(name = "userDao1")
    private UserDao userDao;

    public ArrayList<User> findAllUsers() {
        System.out.println("--11");
        ArrayList<User> list = userDao.findAll();
        System.out.println("--22");
        return list;

    }
}
