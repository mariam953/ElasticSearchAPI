package com.service;

import com.biblio.models.Blog;
import java.util.List;

public interface BlogService {

    List<Blog> findAll();

    Blog findBytitle(String title);

    Blog findByBody(String body);

    void saveOrUpdateBlog(Blog blog);

    void deleteBlog(String id);

}