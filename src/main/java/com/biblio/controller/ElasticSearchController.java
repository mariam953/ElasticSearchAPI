package com.biblio.controller;

import com.biblio.models.Blog;
import com.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/es")
@CrossOrigin("*") // TODO Add WebConfigurer filter for cross origin
public class ElasticSearchController {
    
    @Autowired
    private BlogService blogService;
   
    //@Autowired
    //private BlogRepository repository;

    @GetMapping("/blogs")
    public HttpEntity<String> hello(){
        String resp = new String();
        
        for (Blog customer : blogService.findAll()) {
            resp+=customer;
        }
        
        return ResponseEntity.ok(resp);
    }
    
    @GetMapping("/hello0/{name}")
    public String hello0(@PathVariable("name") String name)
    {
        return "Hello " + name;
    }

    @PostMapping("/visualize/{sheetName}")
    // TODO Implement Global error handling
    public HttpEntity<String> viewSheetData(@RequestParam(name = "file") MultipartFile multipartFile, @PathVariable String sheetName) {
        return ResponseEntity.ok("Post mapping works");
    }
}
