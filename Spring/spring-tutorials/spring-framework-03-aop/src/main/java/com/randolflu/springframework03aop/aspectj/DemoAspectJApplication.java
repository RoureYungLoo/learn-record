package com.randolflu.springframework03aop.aspectj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//@SpringBootApplication
@EnableAspectJAutoProxy
@Configuration
@ComponentScan("com.randolflu.springframework03aop.aspectj")
public class DemoAspectJApplication {
    public static void main(String[] args) {
//        ConfigurableApplicationContext context = SpringApplication.run(DemoAspectJApplication.class);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoAspectJApplication.class);
        Hello bean = context.getBean(Hello.class);
        StringBuilder sb = new StringBuilder("123456");

        String res = bean.say(sb);

        System.out.println("调用方拿到的返回值: "+res);

    }
}
