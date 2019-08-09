package com.kechun;


import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@EnableScheduling
@EnableEurekaClient
@EnableFeignClients
@EnableSwagger2
@SpringBootApplication
public class CommonApplication  {

    private static final Logger LOG = LoggerFactory.getLogger(CommonApplication.class);

    public static void main(String[] args) {
        LOG.info("start");
        SpringApplication.run(CommonApplication .class, args);
        LOG.info("start success");
    }

}

