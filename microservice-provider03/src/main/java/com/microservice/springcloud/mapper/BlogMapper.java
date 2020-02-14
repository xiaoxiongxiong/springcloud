package com.microservice.springcloud.mapper;

import com.microservice.springcloud.entity.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogMapper {
    List<Blog> selectAll();

    Boolean insertBlog(Blog blog);

    Boolean deleteBlog(String id);

    Boolean updateBlog(Blog blog);

    Blog getBlogById(String id);
}
