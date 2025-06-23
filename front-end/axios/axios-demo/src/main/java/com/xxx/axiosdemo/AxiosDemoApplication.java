package com.xxx.axiosdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
public class AxiosDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AxiosDemoApplication.class, args);
    }

}
