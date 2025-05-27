package com.randolflu.springframework02ioc.config.stu;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class Closedistener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println(" ContextClosedEvent 触发了 [1]");
    }
}

@Component
class ClosedListener {

    @EventListener
    @Order(2)
    public void onEvent(ContextClosedEvent event) {
        System.out.println(" ContextClosedEvent 触发了 [2]");

    }

}
