package com.randolflu.springframework02ioc.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Hello3 {
    private String name;
    private User user;
    private List<User> userList;
    private Set<User> userSet;
//    private Map<Object, User> userMap;

    public String getHelloStr() {
        return "Hello World 3 IoC! By " + name;
    }

    public String getName() {
        return name;
    }

    public Hello3(String name) {
        this.name = name;
        System.out.println("调用有参构造");
    }

    public Hello3() {
        System.out.println("调用无参构造");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("setName");

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        System.out.println("setUser");

        this.user = user;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        System.out.println("setUserList");

        this.userList = userList;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        System.out.println("setUserSet");

        this.userSet = userSet;
    }

//    public Map<Object, User> getUserMap() {
//        return userMap;
//    }
//
//    public void setUserMap(Map<Object, User> userMap) {
//        System.out.println("setUserMap");
//
//        this.userMap = userMap;
//    }

    @Override
    public String toString() {
        return "Hello3{" +
                "name='" + name + '\'' +
//                ", user=" + user +
                ", userList=" + userList +
                ", userSet=" + userSet +
//                ", userMap=" + userMap +
                '}';
    }
}
