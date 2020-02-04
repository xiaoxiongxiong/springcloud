package com.microservice.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProviderMain {
    public static final Logger logger = LoggerFactory.getLogger(ProviderMain.class);
    public static void main(String[] args) {
        SpringApplication.run(ProviderMain.class, args);
        logger.info("*************************ProviderMain：启动成功******************************");
    }
}
