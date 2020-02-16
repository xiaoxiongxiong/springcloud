package com.microservice.springcloud;

import com.microservice.myRule.MySelfRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "MICROSERVICECLOUD-BLOG", configuration = MySelfRule.class)
public class ConsumerMain {
	public static final Logger logger = LoggerFactory.getLogger(ConsumerMain.class);

	public static void main(String[] args) {
		SpringApplication.run(ConsumerMain.class, args);
		logger.info("*************************ConsumerMain：启动成功******************************");
	}
}
