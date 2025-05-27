package com.randolflu.springframework02ioc.applications;

import com.randolflu.springframework02ioc.components.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;

@SpringBootApplication
public class SpringFramework02IocApplication4 {
    public static void main(String[] args) {
        SpringApplication.run(SpringFramework02IocApplication4.class);

        /* 使用XML配置文件的容器 */
        ApplicationContext context = new ClassPathXmlApplicationContext("beans4.xml");

        Order order = (Order) context.getBean("order");
        order.setId(123213L);
        System.out.println(order);

        Long id = new Random().nextLong() + 10000;

        OrderRepository repository = context.getBean(OrderRepository.class);
        repository.setId(id);
        System.out.println(repository);

        OrderService orderService = context.getBean(OrderService.class);
        System.out.println(orderService);
        System.out.println(orderService.getId());

        OrderController controller = context.getBean(OrderController.class);
        System.out.println(controller);

        UserController bean = context.getBean(UserController.class);
        System.out.println(bean);

    }

}
