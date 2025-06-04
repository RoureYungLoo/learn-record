package com.randolflu.springframework02ioc.config.stu;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/* 自定义事件的发布者 */
@Component
public class MyEventPublisher implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher publisher;

    /* 发布事件 */
    public void fire() {
        MyEvent myEvent = new MyEvent("event from myEvent");
        publisher.publishEvent(myEvent);
        System.out.println("自定义事件发布成功");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}
