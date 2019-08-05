package com.kechun;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.scheduling.annotation.EnableScheduling;



@EnableScheduling
@EnableAutoConfiguration(exclude = {FreeMarkerAutoConfiguration.class})
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication  {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication .class, args);
    }
}

