package com.example.myappapiusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MyappApiUsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyappApiUsersApplication.class, args);
    }

}
