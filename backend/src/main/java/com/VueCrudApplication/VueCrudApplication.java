package com.VueCrudApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class VueCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(VueCrudApplication.class, args);
    }

}