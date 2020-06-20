package com.biblio.repository;

import com.biblio.models.Blog;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface BlogRepository extends MongoRepository<Blog, String> {

    //public List<Blog> findAll();
    
    Blog findBytitle(String title);

    Blog findByBody(String body);

}