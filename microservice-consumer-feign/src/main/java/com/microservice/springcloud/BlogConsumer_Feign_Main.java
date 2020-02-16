package com.microservice.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.microservice.springcloud"})
//@ComponentScan(value = "com.microservice.springcloud")
public class BlogConsumer_Feign_Main {
	public static final Logger logger = LoggerFactory.getLogger(BlogConsumer_Feign_Main.class);

	public static void main(String[] args) {
		SpringApplication.run(BlogConsumer_Feign_Main.class, args);
		logger.info("*************************ConsumerMain：启动成功******************************");
	}
}
