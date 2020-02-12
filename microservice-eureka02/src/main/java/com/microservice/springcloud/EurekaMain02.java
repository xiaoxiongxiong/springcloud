package com.microservice.springcloud;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaMain02 {
	public static final Logger logger = LoggerFactory.getLogger(EurekaMain02.class);

	public static void main(String[] args) {
		SpringApplication.run(EurekaMain02.class, args);
		logger.info("*************************EurekaMain02：启动成功******************************");
	}
}

