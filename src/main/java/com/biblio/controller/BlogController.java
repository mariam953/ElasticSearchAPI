package com.controller;


import com.biblio.models.Blog;
import com.service.BlogService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping(value = "/")
    public List<Blog> getAllBlogs() {
        return blogService.findAll();
    }
    
    @GetMapping(value = "/{title}")
    public Blog getBlogByTitle(@PathVariable("title") String title) {
        return blogService.findBytitle(title);
    }

    @GetMapping(value = "/{body}")
    public Blog getBlogByBody(@PathVariable("body") String body) {
        return blogService.findByBody(body);
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> saveOrUpdateBlog(@RequestBody Blog blog) {
        blogService.saveOrUpdateBlog(blog);
        return new ResponseEntity("Blog added successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{blogNumber}")
    public void deleteBlog(@PathVariable String id) {
        blogService.deleteBlog(id);
    }

}