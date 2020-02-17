package com.microservice.springcloud.service;

import com.microservice.springcloud.entity.Blog;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//@FeignClient(value = "MICROSERVICECLOUD-BLOG")
@FeignClient(value = "MICROSERVICECLOUD-BLOG", fallbackFactory = BlogClientServiceFallbackFactory.class)
public interface BlogClientService {

	@RequestMapping(value = "/blog/getBlogs", method = RequestMethod.GET)
	public List<Blog> getBlogs();

	@RequestMapping(value = "/blog/saveBlog", method = RequestMethod.POST)
	public Boolean saveBlog(@RequestBody Blog blog);

	@RequestMapping(value = "/blog/deleteBlog/{id}", method = RequestMethod.DELETE)
	public Boolean deleteBlog(@PathVariable("id") String id);

	@RequestMapping(value = "/editBlog", method = RequestMethod.PUT)
	public Boolean updateBlog(@RequestBody Blog blog);

	@RequestMapping(value = "/blog/getBlogById/{id}", method = RequestMethod.GET)
	public Blog getBlogById(@PathVariable("id") String id);
}
