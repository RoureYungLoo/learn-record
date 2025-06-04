package com.randolflu.springframework02ioc.task.threadpool;

import com.randolflu.springframework02ioc.task.config.AsyncConfig;
import com.randolflu.springframework02ioc.task.service.UserService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

//@EnableAsync
@SpringBootApplication
@ComponentScan("com.randolflu.springframework02ioc.task.config")
public class DemoAsyncTask {
    public static void main(String[] args) {
//        ConfigurableApplicationContext context = SpringApplication.run(DemoAsyncTask.class);

//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans-task.xml");
//        ThreadPoolTaskExecutor executor = (ThreadPoolTaskExecutor) context.getBean("threadPoolTaskExecutor");


//        executor.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("异步方法执行了");
//            }
//        });

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(UserService.class, AsyncConfig.class);
        context.refresh();

        System.out.println(Thread.currentThread().getName() + "开始了");

        ThreadPoolTaskExecutor taskExecutor = (ThreadPoolTaskExecutor) context.getBean("myTaskExecutor");
        UserService userService = context.getBean(UserService.class);
        userService.save();
        userService.save();
        userService.save();

//        context.close();

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//
//        }

        System.out.println(Thread.currentThread().getName() + "结束了");

    }

}
