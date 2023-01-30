package com.sn.dev.backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${upload.dir}")
    private String uploadDir;
    public String getUploadDir() {
        return uploadDir;
    }
}
