package com.microservice.springcloud.service;

import com.microservice.springcloud.entity.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> selectAll();

    Boolean insertBlog(Blog blog);

    Boolean deleteBlog(String id);

    Boolean updateBlog(Blog blog);

    Blog getBlogById(String id);
}
