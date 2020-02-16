package com.microservice.springcloud.controller;

import com.microservice.springcloud.entity.Blog;
import com.microservice.springcloud.service.BlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {

    public static final Logger logger = LoggerFactory.getLogger(BlogController.class);
    @Autowired
    private BlogService blogService;
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/getBlogs", method = RequestMethod.GET)
    @ResponseBody
    public List<Blog> getBlogs() {
        List<Blog> list = blogService.selectAll();
        return list;
    }

    @RequestMapping(value = "/saveBlog", method = RequestMethod.POST)
    @ResponseBody
    public Boolean saveBlog(HttpServletRequest request, @RequestBody Blog blog) {
        Boolean result = blogService.insertBlog(blog);
        return result;
    }

    @RequestMapping(value = "/deleteBlog/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Boolean deleteBlog(@PathVariable("id") String id) {
        Boolean result = blogService.deleteBlog(id);
        return result;
    }

    @RequestMapping(value = "/editBlog", method = RequestMethod.PUT)
    @ResponseBody
    public Boolean updateBlog(@RequestBody Blog blog) {
        Boolean result = blogService.updateBlog(blog);
        return result;
    }

    @RequestMapping(value = "/getBlogById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Blog getBlogById(@PathVariable("id") String id) {
        Blog blog = blogService.getBlogById(id);
        return blog;
    }

    //获取eureka信息接口
    @RequestMapping(value = "/discovery", method = RequestMethod.GET)
    @ResponseBody
    public Object discovery(){
        List<String> list = discoveryClient.getServices();
        System.out.println("******" + list);

        List<ServiceInstance> srvList = discoveryClient.getInstances("MICROSERVICECLOUD-BLOG");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t" + element.getUri());
        }
        return this.discoveryClient;
    }
}

