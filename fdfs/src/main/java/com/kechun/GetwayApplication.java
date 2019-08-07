package com.kechun;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@EnableEurekaClient
@SpringBootApplication
public class GetwayApplication {


    public static void main(String[] args) {
        SpringApplication.run(GetwayApplication.class, args);
    }

}

