package com.gcu.topic213;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {"com.gcu"})
@EnableMongoRepositories(basePackages = "com.gcu.data.repository")
public class Topic213Application {

    public static void main(String[] args) {
        SpringApplication.run(Topic213Application.class, args);
    }
}