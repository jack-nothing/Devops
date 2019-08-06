package com.kechun;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;



@EnableScheduling
@EnableEurekaClient
@SpringBootApplication
public class EurekaApplication  {

    private static final Logger LOG = LoggerFactory.getLogger(EurekaApplication.class);

    public static void main(String[] args) {
        LOG.info("start");
        SpringApplication.run(EurekaApplication .class, args);
        LOG.info("start success");
    }
}

