package com.example.springboot06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Springboot06Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot06Application.class, args);
    }

}
