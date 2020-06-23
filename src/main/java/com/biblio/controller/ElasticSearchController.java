package com.biblio.controller;

import com.biblio.models.BlogEs;
import com.biblio.service.BlogEsService;
import com.biblio.service.BlogService;
import java.util.List;
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
@RequestMapping("/es")
@CrossOrigin("*")
public class ElasticSearchController {
   
    @Autowired
    private BlogEsService blogEsService;

    @GetMapping("/blogs")
    public HttpEntity<String> findAll(){
        
        String resp=new String();
 
        Iterable<BlogEs> blogs = blogEsService.findAll();
        
        for (BlogEs customer : blogs) {
                    resp+=customer;
                }
        return ResponseEntity.ok(resp);
    }
    
    @GetMapping("/findbyid/{id}")
    public String findById(@PathVariable("id") String id)
    {
        BlogEs b = blogEsService.findOne(id);
        if(b == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Blog with id "+id+" not found in ES cluster");	        
        }
        return b.toString();	

    }
    
    
    @GetMapping("/findbytitle/{title}")
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
    

    @PutMapping(value = "/insert")
    public HttpEntity<String> save(@Valid BlogCriteria Blogmodel)
    {
        BlogEs b = new BlogEs(Blogmodel.getTitle(), Blogmodel.getBody());
        b = blogEsService.save(b);

        return ResponseEntity.ok(b.toString());
    }
    
    
    @DeleteMapping(value = "/dltById/{id}")
    public void deleteBlog(@PathVariable String id) {
        blogEsService.deleteById(id);
    }
}
