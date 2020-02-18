package com.microservice.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient//服务发现
public class BlogProviderMain {
    public static final Logger logger = LoggerFactory.getLogger(BlogProviderMain.class);
    public static void main(String[] args) {
        SpringApplication.run(BlogProviderMain.class, args);
        logger.info("*************************BlogProviderMain：启动成功******************************");
    }
}
