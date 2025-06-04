package com.randolflu.springframework02ioc.task.service;

import com.randolflu.springframework02ioc.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@Service
public class UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Async("myTaskExecutor")
    public void save() {
        LOGGER.info("starting executing " + Thread.currentThread().getName());

        for (int i = 0; i < 10; i++) {
            try {
                Class<?> clazz = Class.forName("com.randolflu.springframework02ioc.entity.User");
                Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, int.class);
                Object o = constructor.newInstance("李四", 25);
                User u = (User) o;
                System.out.println(u);
            } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                     InstantiationException | IllegalAccessException e) {
                LOGGER.error("用户对象实例化失败");
                throw new RuntimeException(e);
            }
        }

        LOGGER.info("done executing " + Thread.currentThread().getName());
    }

    @Scheduled(fixedDelay = 1000)
    public void task2() {
        LOGGER.info("执行完等待1000ms");
    }

    @Scheduled(fixedRate = 1000)
    public void task3() {
        LOGGER.info("每隔1000ms执行一次");
    }

    @Scheduled(initialDelay = 5000, fixedRate = 1000)
    public void task4() {
        LOGGER.info("第一次执行先等待5000ms,然后 每隔1000ms执行一次");
    }

    @Scheduled(cron = "*/3 * * * * *")
    public void task5() {
        LOGGER.info("cron = */3 * * * * *");
    }
}
