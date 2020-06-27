package com.biblio.controller;

import com.biblio.models.BookEs;
import com.biblio.service.BookEsService;
import com.biblio.service.BookService;
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
    private BookEsService bookEsService;

    @GetMapping("/books")
    public HttpEntity<String> findAll(){
        
        String resp=new String();
 
        Iterable<BookEs> books = bookEsService.findAll();
        
        for (BookEs customer : books) {
                    resp+=customer;
                }
        return ResponseEntity.ok(resp);
    }
    
    @GetMapping("/findbyid/{id}")
    public String findById(@PathVariable("id") String id)
    {
        BookEs b = bookEsService.findOne(id);
        if(b == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Blog with id "+id+" not found in ES cluster");	        
        }
        return b.toString();	

    }
    
    
    @GetMapping("/findbytitle/{title}")
    public HttpEntity<String> findByTitle(@PathVariable("title") String title)
    {
        String resp=new String();
        
        Page<BookEs> b = bookEsService.findByTitle(title, PageRequest.of(0, 5000));
        List<BookEs> listBlogs = b.getContent();
        for (BookEs customer : listBlogs) {
                    resp+=customer;
                }
        return ResponseEntity.ok(resp);
    }
    
 }
