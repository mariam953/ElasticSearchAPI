package com.biblio.controller;

import com.biblio.models.Blog;
import com.biblio.models.BlogEs;
import com.biblio.service.BlogEsService;
import com.biblio.service.BlogService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/api")
@CrossOrigin("*") // TODO Add WebConfigurer filter for cross origin
public class ApiController {
    
    @Autowired
    private BlogEsService blogEsService;

    @Autowired
    private BlogService blogService;
    
    @GetMapping("/getallbooks")
    public List<BlogEs> findAll(){
        try {
            Iterable<BlogEs> blogs = blogEsService.findAll();
            List<BlogEs> BlogsList = new ArrayList<>();
            for (BlogEs item : blogs) {
                BlogsList.add(item);
            }

            return BlogsList;
        } catch (Exception e) {
            return null;
        }
    }
    
    @GetMapping("/findbookbyid/{id}")
    public String findById(@PathVariable("id") String id)
    {
        BlogEs b = blogEsService.findOne(id);
        if(b == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Blog with id "+id+" not found in ES cluster");	        
        }
        return b.toString();	

    }
    
    @GetMapping("/findbookbytitle/{title}")
    public HttpEntity<String> findByTitle(@PathVariable("title") String title)
    {
        String resp=new String();
        
        Page<BlogEs> b = blogEsService.findByTitle(title, PageRequest.of(0, 5000));
        List<BlogEs> listBlogs = b.getContent();
        for (BlogEs customer : listBlogs) {
                    resp+=customer;
                }
        return ResponseEntity.ok(resp);
    }

    @PutMapping(value = "/addbook")
    public ResponseEntity<String> insert(@RequestBody Blog blog)
    {
        //Blog b = new Blog(Blogmodel.getTitle(), Blogmodel.getBody());
        blogService.saveOrUpdateBlog(blog);
        return ResponseEntity.ok("Ok");
    }
    
    @DeleteMapping(value = "/deletebook/{id}")
    public void deleteBlog(@PathVariable String id) {
        blogService.deleteBlog(id);
    }
}
