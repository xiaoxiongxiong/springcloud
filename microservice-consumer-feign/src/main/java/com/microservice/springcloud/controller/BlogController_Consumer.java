package com.microservice.springcloud.controller;

import com.microservice.springcloud.entity.Blog;
import com.microservice.springcloud.service.BlogClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumer/blog")
public class BlogController_Consumer {

	@Autowired
	private BlogClientService blogClientService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Blog> getBlogs() {
		return blogClientService.getBlogs();
	}

	@RequestMapping(value = "/saveBlog", method = RequestMethod.POST)
	public Boolean saveBlog(@RequestBody Blog blog) {
		return blogClientService.saveBlog(blog);
	}

	@RequestMapping(value = "/deleteBlog/{id}", method = RequestMethod.DELETE)
	public Boolean deleteBlog(@PathVariable("id") String id) {
		return blogClientService.deleteBlog(id);
	}

	@RequestMapping(value = "/editBlog", method = RequestMethod.PUT)
	public Boolean updateBlog(@RequestBody Blog blog) {
		return blogClientService.updateBlog(blog);
	}

	@RequestMapping(value = "/getBlogById/{id}", method = RequestMethod.GET)
	public Blog getBlogById(@PathVariable(value = "id") String id) {
		return blogClientService.getBlogById(id);
	}
}
