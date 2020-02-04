package com.microservice.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumerMain {
	public static final Logger logger = LoggerFactory.getLogger(ConsumerMain.class);

	public static void main(String[] args) {
		SpringApplication.run(ConsumerMain.class, args);
		logger.info("*************************ConsumerMain：启动成功******************************");
	}
}
