package com.kechun;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
 * 中心服务
 */
@EnableDiscoveryClient
@EnableEurekaServer
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class CenterServerApplication  {

    public static void main(String[] args) {
        SpringApplication.run(CenterServerApplication.class, args);
    }
}

