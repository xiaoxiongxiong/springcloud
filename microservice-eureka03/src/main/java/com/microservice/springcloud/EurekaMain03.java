package com.microservice.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaMain03 {
	public static final Logger logger = LoggerFactory.getLogger(EurekaMain03.class);

	public static void main(String[] args) {
		SpringApplication.run(EurekaMain03.class, args);
		logger.info("*************************EurekaMain03：启动成功******************************");
	}
}
