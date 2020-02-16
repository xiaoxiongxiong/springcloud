package com.microservice.springcloud.cfgBean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
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

	@Bean
	public IRule myRule(){
//		return new RoundRobinRule();//默认轮询算法
//		return new RandomRule();//用随机算法替换默认轮询算法
		return new RetryRule();//用重试算法替换默认轮询算法，默认轮询算法，若多次重试失败回自动跳过失败服务
	}
}
