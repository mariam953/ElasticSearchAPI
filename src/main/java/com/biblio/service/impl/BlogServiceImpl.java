package com.biblio.service.impl;

import com.biblio.models.Blog;
import com.biblio.repository.Mongo.BlogRepository;
import com.biblio.service.BlogService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findBytitle(String title) {
         return blogRepository.findBytitle(title);
    }

    @Override
    public Blog findByBody(String body) {
        return blogRepository.findByBody(body);
    }
    
    @Override
    public void saveOrUpdateBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void deleteBlog(String id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Optional<Blog> findById(String id) {
        return blogRepository.findById(id);        
    }

}