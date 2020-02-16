package com.microservice.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient//服务发现
@EnableCircuitBreaker//hystrix熔断机制
public class BlogProvider_Hystrix_Main {
    public static final Logger logger = LoggerFactory.getLogger(BlogProvider_Hystrix_Main.class);
    public static void main(String[] args) {
        SpringApplication.run(BlogProvider_Hystrix_Main.class, args);
        logger.info("*************************BlogProvider_Hystrix_Main：启动成功******************************");
    }
}
