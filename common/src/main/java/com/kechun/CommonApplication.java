package com.kechun;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;



@EnableEurekaClient
@SpringBootApplication
public class CommonApplication  {

    private static final Logger LOG = LoggerFactory.getLogger(CommonApplication.class);

    public static void main(String[] args) {
        LOG.info("start");
        SpringApplication.run(CommonApplication .class, args);
        LOG.info("start success");
    }
}

