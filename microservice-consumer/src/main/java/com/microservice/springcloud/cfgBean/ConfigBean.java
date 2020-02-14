package com.microservice.springcloud.cfgBean;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
	@Bean
	//spring cloud Ribbon是基于Netfix Ribbon实现的一套客户端 负载均衡工具
	@LoadBalanced //添加负在均衡注解
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
