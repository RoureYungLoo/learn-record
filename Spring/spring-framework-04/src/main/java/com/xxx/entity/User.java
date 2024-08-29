package com.xxx.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// @Component
@Component(value = "user1") // value 的值是 Bean 的id
// <bean id="user1" class="com.xxx.entity.User"/>


public class User {
    public String username = "testUser";

    @Value("Shanghai") // <property name="address" value="Shanghai"/>
    private String address ;

    private String hobby;

    @Value("钓鱼")
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
