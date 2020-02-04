package com.microservice.springcloud.mapper;

import com.microservice.springcloud.entity.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogMapper {
    List<Blog> selectAll();

    Integer insertBlog(Blog blog);

    Integer deleteBlog(String id);

    Integer updateBlog(Blog blog);
}
