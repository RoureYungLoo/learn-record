
package com.xxx.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/* Spring MVC 配置类（） */
@Configuration
@ComponentScan(basePackages = {"com.xxx.controller","com.xxx.config"})
@EnableWebMvc
public class SpringMvcConfig {
}
