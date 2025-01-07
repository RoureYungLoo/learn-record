package org.example.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class UserService {

    @Autowired  // 用于成员变量
    @Qualifier(value = "userDao2")
    private UserDao userDao;

    //     @Autowired // 用于构造方法
    public UserService(UserDao userDao) {
        System.out.println("UserService Constructor with one parameter");
        this.userDao = userDao;
    }

    public UserService() {
        System.out.println("UserService Constructor with no parameters");
    }

    //     @Autowired // 用于setter()方法
    public void setUserDao(UserDao userDao) {
        System.out.println("UserService setUserDao");
        this.userDao = userDao;
    }

    // @Autowired // 用于成员方法
    public void Method(SpellCheck spellCheck) {
        System.out.println("UserService MethodMember");
        spellCheck.checkSpelling();
    }

    public void selectList() {
        userDao.selectList();
    }

    @PostConstruct
    public void init() {
        System.out.println("-- init --");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("-- destroy --");
    }

}
