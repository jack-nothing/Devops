package com.kechun;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@EnableEurekaClient
@SpringBootApplication
public class FDFSApplication {

    public static void main(String[] args) {
        SpringApplication.run(FDFSApplication.class, args);
    }

}

