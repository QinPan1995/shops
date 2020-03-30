package com.project.shops.aop;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author qinpan
 * @create 2020-03-26 21:38
 */
@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {
    private String uploadDir;

    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}
