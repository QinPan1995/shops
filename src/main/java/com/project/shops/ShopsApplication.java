package com.project.shops;

import com.project.shops.aop.FileStorageProperties;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class ShopsApplication{

    public static void main(String[] args) {
        SpringApplication.run(ShopsApplication.class, args);
    }



}
