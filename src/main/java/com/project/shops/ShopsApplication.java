package com.project.shops;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableConfigurationProperties(value = {UserProperties.class, MinioProperties.class})
@MapperScan(basePackages = {"com.project.shops.mapper"})
@SpringBootApplication
public class ShopsApplication{

    public static void main(String[] args) {
        SpringApplication.run(ShopsApplication.class, args);
    }



}
