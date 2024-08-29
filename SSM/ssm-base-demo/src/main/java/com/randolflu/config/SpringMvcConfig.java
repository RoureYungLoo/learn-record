package com.randolflu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"com.randolflu.controller","com.randolflu.exception","com.randolflu.config"})
@EnableWebMvc
public class SpringMvcConfig {
}
