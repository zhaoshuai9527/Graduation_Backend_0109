package com.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RegisterApplication {
    public static void main(String[] args) {
        SpringApplication.run(RegisterApplication.class);
    }
}
