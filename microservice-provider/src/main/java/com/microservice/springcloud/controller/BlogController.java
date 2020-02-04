package com.microservice.springcloud.controller;

import com.microservice.springcloud.entity.Blog;
import com.microservice.springcloud.service.BlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {

    public static final Logger logger = LoggerFactory.getLogger(BlogController.class);
    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/getBlogs", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getBlogs() {
        Map<String, Object> result = new HashMap<>();
        try {
            List<Blog> list = blogService.selectAll();
            result.put("status", "success");
            result.put("data", list);
            result.put("msg", "查询成功！");
        } catch (Exception e) {
            result.put("status", "error");
            result.put("msg", e.getMessage());
            logger.info(e.toString());
            logger.info(e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/saveBlog", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> saveBlog(HttpServletRequest request, @RequestBody Blog blog) {
        Map<String, Object> result = new HashMap<>();
        try {
            Integer i = blogService.insertBlog(blog);
            if (i > 0) {
                result.put("status", "success");
                result.put("data", "保存成功！");
            } else {
                result.put("status", "error");
                result.put("data", "");
                result.put("msg", "未保存数据或保存失败！");
            }
        } catch (Exception e) {
            result.put("status", "error");
            result.put("msg", e.getMessage());
            logger.info(e.toString());
            logger.info(e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/deleteBlog/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteBlog(@PathVariable("id") String id) {
        Map<String, Object> result = new HashMap<>();
        try {
            if (id == null || id.equals("")) {
                result.put("status", "error");
                result.put("data", "");
                result.put("msg", "参数不可为空！");
                return result;
            }

            Integer i = blogService.deleteBlog(id);
            if (i > 0) {
                result.put("status", "success");
                result.put("data", "");
                result.put("msg", "删除成功！");
            } else {
                result.put("status", "error");
                result.put("data", "");
                result.put("msg", "未删除数据或删除失败！");
            }
        } catch (Exception e) {
            result.put("status", "error");
            result.put("data", "");
            result.put("msg", e.getMessage());
            logger.info(e.toString());
            logger.info(e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/editBlog", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> updateBlog(@RequestBody Blog blog) {
        Map<String, Object> result = new HashMap<>();
        try {
            String id = blog.getId();
            if (id == null || id.equals("")) {
                result.put("status", "error");
                result.put("data", "");
                result.put("msg", "参数不可为空！");
                return result;
            }

            Integer i = blogService.updateBlog(blog);
            if (i > 0) {
                result.put("status", "success");
                result.put("data", "");
                result.put("msg", "修改成功！");
            } else {
                result.put("status", "error");
                result.put("data", "");
                result.put("msg", "未修改数据或修改失败！");
            }
        } catch (Exception e) {
            result.put("status", "error");
            result.put("data", "");
            result.put("msg", e.getMessage());
            logger.info(e.toString());
            logger.info(e.getMessage());
        }
        return result;
    }

}
