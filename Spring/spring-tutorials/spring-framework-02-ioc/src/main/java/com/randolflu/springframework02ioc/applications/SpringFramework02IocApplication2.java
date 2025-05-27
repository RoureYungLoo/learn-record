package com.randolflu.springframework02ioc.applications;

import com.randolflu.springframework02ioc.entity.Hello;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringFramework02IocApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(SpringFramework02IocApplication2.class, args);
        ClassPathXmlApplicationContext parentContext = new ClassPathXmlApplicationContext("parent-beans.xml");
        ClassPathXmlApplicationContext childContext = new ClassPathXmlApplicationContext(new String[]{"child-beans.xml"}, true, parentContext);

        parentContext.setId("parentContext");
        childContext.setId("childContext");

        Hello hello = (Hello) parentContext.getBean("hello");
        Hello parentHello = (Hello) parentContext.getBean("parentHello");
        // Hello childHello = (Hello) parentContext.getBean("childHello"); // NoSuchBeanDefinitionException: No bean named 'childHello' available

        if (hello != null) {
            System.out.println(hello.getHelloStr());
        }
        if (parentHello != null) {
            System.out.println(parentHello.getHelloStr());
        }
//        if (childHello != null) {
//            System.out.println(childHello);
//        }


        childContext.setAllowBeanDefinitionOverriding(true);

        hello = (Hello) childContext.getBean("hello");
        parentHello = (Hello) childContext.getBean("parentHello");
        Hello childHello = (Hello) childContext.getBean("childHello");

        if (hello != null) {
            System.out.println(hello.getHelloStr()); // Child
        }
        if (parentHello != null) {
            System.out.println(parentHello.getHelloStr()); // Parent
        }
        if (childHello != null) {
            System.out.println(childHello.getHelloStr()); // Child
        }


    }

}
