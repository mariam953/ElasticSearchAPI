package com.biblio.service;

import com.biblio.models.Blog;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public interface BlogService {

    List<Blog> findAll();
    
    Optional<Blog> findById(String id);

    Blog findBytitle(String title);

    Blog findByBody(String body);

    void saveOrUpdateBlog(Blog blog);

    void deleteBlog(String id);

}