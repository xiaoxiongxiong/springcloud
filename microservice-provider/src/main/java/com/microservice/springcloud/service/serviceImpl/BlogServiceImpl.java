package com.microservice.springcloud.service.serviceImpl;

import com.microservice.springcloud.entity.Blog;
import com.microservice.springcloud.mapper.BlogMapper;
import com.microservice.springcloud.service.BlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogMapper blogMapper;

    @Override
    public List<Blog> selectAll() {
        return blogMapper.selectAll();
    }

    @Override
    public Integer insertBlog(Blog blog) {
        return blogMapper.insertBlog(blog);
    }

    @Override
    public Integer deleteBlog(String id) {
       return blogMapper.deleteBlog(id);
    }

    @Override
    public Integer updateBlog(Blog blog) {
       return blogMapper.updateBlog(blog);
    }


}
