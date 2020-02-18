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
    public Boolean insertBlog(Blog blog) {
        return blogMapper.insertBlog(blog);
    }

    @Override
    public Boolean deleteBlog(String id) {
        return blogMapper.deleteBlog(id);
    }

    @Override
    public Boolean updateBlog(Blog blog) {
        return blogMapper.updateBlog(blog);
    }

    @Override
    public Blog getBlogById(String id) {
        return blogMapper.getBlogById(id);
    }

    ;
}
