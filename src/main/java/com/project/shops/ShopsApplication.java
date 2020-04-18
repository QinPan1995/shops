package com.project.shops;

import com.project.shops.aops.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class ShopsApplication{

    public static void main(String[] args) {
        SpringApplication.run(ShopsApplication.class, args);
    }



}
