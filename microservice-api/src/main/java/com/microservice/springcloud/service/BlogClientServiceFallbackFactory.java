package com.microservice.springcloud.service;

import com.microservice.springcloud.entity.Blog;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
@Component //不要忘记添加注解
public class BlogClientServiceFallbackFactory implements FallbackFactory<BlogClientService> {
	@Override
	public BlogClientService create(Throwable throwable) {
		return new BlogClientService() {
			@Override
			public List<Blog> getBlogs() {
				return null;
			}

			@Override
			public Boolean saveBlog(Blog blog) {
				return null;
			}

			@Override
			public Boolean deleteBlog(String id) {
				return null;
			}

			@Override
			public Boolean updateBlog(Blog blog) {
				return null;
			}

			@Override
			public Blog getBlogById(String id) {
				return new Blog().setId(id).setTitle("该ID：" + id + "没有对应信息，Consumer提供的降级服务，此刻Provider已关闭")
						.setDbSource("no this database in MySQL");
			}
		};
	}
}
