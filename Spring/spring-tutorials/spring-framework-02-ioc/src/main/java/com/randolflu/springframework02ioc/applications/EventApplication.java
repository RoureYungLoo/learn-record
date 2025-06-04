package com.randolflu.springframework02ioc.applications;


import com.randolflu.springframework02ioc.config.stu.MyEventPublisher;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.randolflu.springframework02ioc.config.stu")
@SpringBootApplication
public class EventApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventApplication.class);

        MyEventPublisher myEventPublisher = context.getBean(MyEventPublisher.class);
        myEventPublisher.fire();

        context.close();
    }
}
