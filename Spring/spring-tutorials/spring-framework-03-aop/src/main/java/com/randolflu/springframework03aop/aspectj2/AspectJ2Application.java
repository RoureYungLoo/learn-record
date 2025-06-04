package com.randolflu.springframework03aop.aspectj2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@Configuration
//@EnableAspectJAutoProxy
//@ComponentScan("com.randolflu.springframework03aop.aspectj2")
public class AspectJ2Application {
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AspectJ2Application.class);
//        Hello hello = context.getBean("springHello", Hello.class);
//        String s = hello.sayHello(new StringBuffer(" hahah "));
//        System.out.println(s);
//        String s1 = hello.sayHello(new StringBuffer(" hahahahah"));
//        System.out.println(s1);

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Hello hello = context.getBean("springHello", Hello.class);
        hello.sayHello(new StringBuffer("123"));
//        hello.say();

    }
}
