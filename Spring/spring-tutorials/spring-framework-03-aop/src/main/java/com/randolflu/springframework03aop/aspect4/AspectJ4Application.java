package com.randolflu.springframework03aop.aspect4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectJ4Application {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aspect4.xml");
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aspect4_2.xml");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aspect4_3.xml");
        Order order = (Order) context.getBean("order3");

//        System.out.println(order.getId());
//        System.out.println(order.getCustomerId());
//        System.out.println(order);


        try {
            order.genAnException();
        } catch (Exception e) {

        }
        ApplicationContext
    }
}
