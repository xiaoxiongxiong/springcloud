package com.microservice.springcloud.controller;

import com.microservice.springcloud.entity.Blog;
import com.microservice.springcloud.service.BlogService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/blog")
public class BlogController {

	public static final Logger logger = LoggerFactory.getLogger(BlogController.class);
	@Autowired
	private BlogService blogService;
	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping(value = "/getBlogs", method = RequestMethod.GET)
	public List<Blog> getBlogs() {
		List<Blog> list = blogService.selectAll();
		return list;
	}

	@RequestMapping(value = "/saveBlog", method = RequestMethod.POST)
	public Boolean saveBlog(HttpServletRequest request, @RequestBody Blog blog) {
		Boolean result = blogService.insertBlog(blog);
		return result;
	}

	@RequestMapping(value = "/deleteBlog/{id}", method = RequestMethod.DELETE)
	public Boolean deleteBlog(@PathVariable("id") String id) {
		Boolean result = blogService.deleteBlog(id);
		return result;
	}

	@RequestMapping(value = "/editBlog", method = RequestMethod.PUT)
	public Boolean updateBlog(@RequestBody Blog blog) {
		Boolean result = blogService.updateBlog(blog);
		return result;
	}

	@RequestMapping(value = "/getBlogById/{id}", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "processHystrix_Get")
	public Blog getBlogById(@PathVariable("id") String id) {
		Blog blog = blogService.getBlogById(id);
		if(null == blog){
			throw new RuntimeException("该ID：" + id + "没有对应信息");
		}
		return blog;
	}

	public Blog processHystrix_Get(@PathVariable("id") String id) {
		return new Blog().setId(id).setTitle("该ID：" + id + "没有对应信息，null--@HystrixCommand")
				.setDbSource("no this database in MySQL");
	}

	//获取eureka信息接口
	@RequestMapping(value = "/discovery", method = RequestMethod.GET)
	public Object discovery() {
		List<String> list = discoveryClient.getServices();
		System.out.println("******" + list);

		List<ServiceInstance> srvList = discoveryClient.getInstances("MICROSERVICECLOUD-BLOG");
		for (ServiceInstance element : srvList) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t" + element.getUri());
		}
		return this.discoveryClient;
	}
}

