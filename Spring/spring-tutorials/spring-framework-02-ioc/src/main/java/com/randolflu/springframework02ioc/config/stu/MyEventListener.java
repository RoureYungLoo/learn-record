package com.randolflu.springframework02ioc.config.stu;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class MyEventListener {

    @EventListener
    @Order(1)
    public void onMyEventFire(MyEvent myEvent) {
        System.out.println(myEvent.getSource().toString() + "=========== 监听到自定义事件 ");
    }
}

@Component
@Order(2)
class MyEventListener2 implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println("监听到 " + event.toString());
    }
}