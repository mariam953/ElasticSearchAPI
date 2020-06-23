package com.biblio.repository.Mongo;

import com.biblio.models.Blog;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends MongoRepository<Blog, String> {

    //public List<Blog> findAll();
    
    //Blog findById(String id);
    
    Blog findBytitle(String title);

    Blog findByBody(String body);

}