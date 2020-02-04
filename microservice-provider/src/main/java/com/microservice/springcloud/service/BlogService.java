package com.microservice.springcloud.service;

import com.microservice.springcloud.entity.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> selectAll();

    Integer insertBlog(Blog blog);

    Integer deleteBlog(String id);

    Integer updateBlog(Blog blog);
}
