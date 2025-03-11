package com.gcu.topic213;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication(scanBasePackages = {"com.gcu"})
@EnableJpaRepositories(basePackages = "com.gcu.data.repository")
@EntityScan(basePackages = "com.gcu.data.entity")
public class Topic213Application {

    public static void main(String[] args) {
        SpringApplication.run(Topic213Application.class, args);
    }
}