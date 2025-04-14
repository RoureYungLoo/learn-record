package com.xxx.nacosproviderpayment9003;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderPayment9003Application {

    public static void main(String[] args) {
        SpringApplication.run(NacosProviderPayment9003Application.class, args);
    }

}
