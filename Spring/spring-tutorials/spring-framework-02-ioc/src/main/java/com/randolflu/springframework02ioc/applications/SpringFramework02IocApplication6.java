package com.randolflu.springframework02ioc.applications;

import com.randolflu.springframework02ioc.config.UserConfig;
import com.randolflu.springframework02ioc.config.stu.StudentConfig;
import com.randolflu.springframework02ioc.entity.ContainerInfo;
import com.randolflu.springframework02ioc.entity.Student;
import com.randolflu.springframework02ioc.entity.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
@ComponentScan("com.randolflu.springframework02ioc.config.stu")
//@Import(StudentConfig.class)
public class SpringFramework02IocApplication6 {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringFramework02IocApplication6.class);

//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-lifecycle.xml");

//        Student student = context.getBean(Student.class);

//        context.close();

//        ContainerInfo containerInfo = context.getBean(ContainerInfo.class);
//        ApplicationContext applicationContext = containerInfo.getApplicationContext();
//        for (String name : applicationContext.getBeanDefinitionNames()) {
////            System.out.println(name);
//        }
//        System.out.println(applicationContext.getDisplayName());
//        System.out.println(applicationContext.getApplicationName());

//        BeanFactory beanFactory = containerInfo.getBeanFactory();
//        System.out.println(beanFactory.getClass().getName());

//        context.close();

        context.registerShutdownHook();

    }

}
