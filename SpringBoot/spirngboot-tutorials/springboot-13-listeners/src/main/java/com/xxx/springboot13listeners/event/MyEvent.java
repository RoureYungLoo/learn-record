package com.xxx.springboot13listeners.event;

import com.xxx.springboot13listeners.entity.User;
import org.springframework.context.ApplicationEvent;


/* 自定义事件 */
public class MyEvent extends ApplicationEvent {

    private User user;


    public MyEvent(Object source, User user) {
        super(source);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
