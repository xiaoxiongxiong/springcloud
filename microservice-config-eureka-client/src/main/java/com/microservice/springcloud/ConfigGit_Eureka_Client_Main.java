package com.microservice.springcloud;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ConfigGit_Eureka_Client_Main {
	public static final Logger logger = LoggerFactory.getLogger(ConfigGit_Eureka_Client_Main.class);

	public static void main(String[] args) {
		SpringApplication.run(ConfigGit_Eureka_Client_Main.class, args);
		logger.info("*************************ConfigGit_Eureka_Client_Main：启动成功******************************");
	}
}

