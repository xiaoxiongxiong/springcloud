package com.microservice.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerMain {
	public static final Logger logger = LoggerFactory.getLogger(ConfigServerMain.class);
	public static void main(String[] args) {
		SpringApplication.run(ConfigServerMain.class, args);
		logger.info("*************************ConfigServerMain：启动成功******************************");
	}
}
