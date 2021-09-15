package com.example.serviceget;

import com.example.serviceget.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
@Import(SecurityConfig.class)
@ComponentScan(basePackages = {"Controller","Model","Service","Data"})
@EntityScan(basePackages = {"model"})
@EnableJpaRepositories(basePackages = {"Data"})
@EnableMongoRepositories(basePackages = {"Data"})
@SpringBootApplication
public class ServiceGetApplication {

    public static void main(String[] args) {
        SpringApplication.run(com.example.serviceget.ServiceGetApplication.class, args);
    }

}
