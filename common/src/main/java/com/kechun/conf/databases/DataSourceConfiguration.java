package com.kechun.conf.databases;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration
@Primary
@Slf4j
@MapperScan("com.kechun.dao")
public class DataSourceConfiguration{

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource readDataSource(){
        DruidDataSource dds = new DruidDataSource();
        return dds;
    }

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}