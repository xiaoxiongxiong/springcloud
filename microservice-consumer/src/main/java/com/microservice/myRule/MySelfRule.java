package com.microservice.myRule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelfRule {
	@Bean
	public IRule myRule(){
//		return new RandomRule();//编写自己的自定义算法
		return new RandomRule_ZY();
	}
}
