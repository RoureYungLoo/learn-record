package com.randolflu.springframework02ioc.task.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync // 开启异步支持
public class AsyncConfig {

    @Bean
    public ThreadPoolTaskExecutor myTaskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(4);
        taskExecutor.setMaxPoolSize(8);
        taskExecutor.setQueueCapacity(32);
        taskExecutor.setAllowCoreThreadTimeOut(true);
        taskExecutor.setPrestartAllCoreThreads(true);
        taskExecutor.setKeepAliveSeconds(60);
        taskExecutor.setThreadNamePrefix("TPTE-THD-");
        taskExecutor.initialize();
        return taskExecutor;
    }
}
