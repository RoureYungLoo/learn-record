package com.randolflu.springframework02ioc.applications;

import com.randolflu.springframework02ioc.entity.Car;
import com.randolflu.springframework02ioc.entity.SomeType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringFramework02IocApplication3 {
    public static void main(String[] args) {
        SpringApplication.run(SpringFramework02IocApplication3.class);

        ApplicationContext context = new ClassPathXmlApplicationContext("beans3.xml");
//        Hello3 hello1 = (Hello3) context.getBean("hello1");
//        System.out.println(hello1.getHelloStr());

//        Hello3 hello2 = (Hello3) context.getBean("hello2");
//        System.out.println(hello2);

//        Hello3 hello3 = (Hello3) context.getBean("hello3");
//        System.out.println(hello3);


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        SomeType t = (SomeType) context.getBean("type1");
//        Car car = (Car) context.getBean("car1");
        Car car2 = (Car) context.getBean("car2");


    }

}
