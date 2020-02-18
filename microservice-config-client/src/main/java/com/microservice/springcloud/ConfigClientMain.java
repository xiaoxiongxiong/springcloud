package com.microservice.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigClientMain {
	public static final Logger logger = LoggerFactory.getLogger(ConfigClientMain.class);
	public static void main(String[] args) {
		SpringApplication.run(ConfigClientMain.class, args);
		logger.info("*************************ConfigClientMain：启动成功******************************");
	}
}
