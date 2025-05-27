package com.randolflu.springframework02ioc.applications;

import com.randolflu.springframework02ioc.config.UserConfig;
import com.randolflu.springframework02ioc.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringFramework02IocApplication5 {
    public static void main(String[] args) {
        SpringApplication.run(SpringFramework02IocApplication5.class);


        /* 使用注解的容器 */
        ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);

        User user = (User) context.getBean("user");
        User user2 = (User) context.getBean("user");
//        user.setWho("zhangsan");
//        user.setAge(23);
        System.out.println(user);
        System.out.println(user==user2);


        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }

    }

}
