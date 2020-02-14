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
public class ProviderMain03 {
    public static final Logger logger = LoggerFactory.getLogger(ProviderMain03.class);
    public static void main(String[] args) {
        SpringApplication.run(ProviderMain03.class, args);
        logger.info("*************************ProviderMain03：启动成功******************************");
    }
}
