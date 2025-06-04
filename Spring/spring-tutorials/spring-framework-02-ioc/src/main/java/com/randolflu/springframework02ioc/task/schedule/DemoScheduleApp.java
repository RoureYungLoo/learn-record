package com.randolflu.springframework02ioc.task.schedule;

import com.randolflu.springframework02ioc.task.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

import java.time.LocalDateTime;
import java.util.Date;

@SpringBootApplication
@ComponentScan("com.randolflu.springframework02ioc.task.config")
public class DemoScheduleApp {
    public static final Logger LOGGER = LoggerFactory.getLogger(DemoScheduleApp.class);
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoScheduleApp.class);


//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        Object bean = context.getBean("taskScheduler");
        ThreadPoolTaskScheduler taskScheduler = (ThreadPoolTaskScheduler) bean;

        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                LOGGER.info("====== "+ LocalDateTime.now().toString());
            }
        };
        CronTrigger trigger1 = new CronTrigger("*/2 * * * * *");
        taskScheduler.schedule(task1,trigger1);

        UserService userService = context.getBean(UserService.class);
        userService.task2();
        userService.task3();
        userService.task4();
        userService.task5();
    }
}
