package com.xxx.demo03;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.xxx.demo03"})
@EnableAspectJAutoProxy
public class SpringConfig {

}
