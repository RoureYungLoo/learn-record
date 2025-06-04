package com.randolflu.springframework02ioc.applications;

import com.randolflu.springframework02ioc.entity.Hello;
import com.randolflu.springframework02ioc.lifecycle.HelloLifeCycle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;

//@SpringBootApplication
@ComponentScan("com.randolflu.springframework02ioc.lifecycle")
public class LifeCycleMainApplication {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleMainApplication.class);

        context.start();
        HelloLifeCycle lifeCycle1 = context.getBean("lifecycle", HelloLifeCycle.class);
//        HelloLifeCycle lifeCycle2 = context.getBean("lifeCycle", HelloLifeCycle.class);

        lifeCycle1.hello();

        context.close();

        lifeCycle1.hello();
//        lifeCycle2.hello();




    }
}
