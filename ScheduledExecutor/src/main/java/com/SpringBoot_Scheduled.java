package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBoot_Scheduled {
    public static void main(String[] args) {
        SpringApplication.run(SpringBoot_Scheduled.class);
    }
}
