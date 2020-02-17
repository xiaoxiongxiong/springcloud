package com.microservice.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class Zuul_9527_Main {
	public static final Logger logger = LoggerFactory.getLogger(Zuul_9527_Main.class);
	public static void main(String[] args) {
		SpringApplication.run(Zuul_9527_Main.class, args);
		logger.info("*************************Zuul_9527_Main：启动成功******************************");
	}
}
