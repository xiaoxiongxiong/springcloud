package com.microservice.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class BlogConsumer_DashBoard_Main {
	public static final Logger logger = LoggerFactory.getLogger(BlogConsumer_DashBoard_Main.class);

	public static void main(String[] args) {
		SpringApplication.run(BlogConsumer_DashBoard_Main.class, args);
		logger.info("*************************BlogConsumer_DashBoard_Main：启动成功******************************");
	}
}
