package com.microservice.springcloud.controller;

import com.microservice.springcloud.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class BlogController_Consumer {
//	public static final String RES_URL_PREFIX = "http://localhost:8001";
	public static final String RES_URL_PREFIX = "http://MICROSERVICECLOUD-BLOG";

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/blog/add")
	public Boolean add(Blog blog) {
		return restTemplate.postForObject(RES_URL_PREFIX + "/blog/saveBlog", blog, Boolean.class);
	}

	@RequestMapping("/blog/list")
	public List<Blog> list() {
		return restTemplate.getForObject(RES_URL_PREFIX + "/blog/getBlogs", List.class);
	}

	@RequestMapping("/blog/get/{id}")
	public Blog getBlogById(@PathVariable("id") String id) {
		return restTemplate.getForObject(RES_URL_PREFIX + "/blog/getBlogById/" + id, Blog.class);
	}

	//消费端调用服务发现
	@RequestMapping(value = "/blog/discovery")
	public Object discovery(){
		return restTemplate.getForObject(RES_URL_PREFIX + "/blog/discovery", Object.class);
	}
}
