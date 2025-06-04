package com.randolflu.springframework02ioc.config.stu;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

import java.time.Clock;

/* 自定义事件 */
public class MyEvent extends ApplicationEvent {
    public MyEvent(Object source) {
        super(source);
    }

    public MyEvent(Object source, Clock clock) {
        super(source, clock);
    }
}
