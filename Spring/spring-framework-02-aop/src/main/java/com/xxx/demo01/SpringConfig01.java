package com.xxx.demo01;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.xxx.demo01"})
@EnableAspectJAutoProxy // 开启切面
public class SpringConfig01 {
}
