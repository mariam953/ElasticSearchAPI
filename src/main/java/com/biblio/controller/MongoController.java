package com.biblio.controller;

import com.biblio.models.Blog;
import com.biblio.service.BlogService;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/mongo")
@CrossOrigin("*") // TODO Add WebConfigurer filter for cross origin
public class MongoController {
    
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
    
    @GetMapping("/findbytitle/{title}")
    public String hello0(@PathVariable("title") String title)
    {
        Blog b = blogService.findBytitle(title);
        return b.toString();
    }
    
    @GetMapping("/findbyid/{id}")
    public String findById(@PathVariable("id") String id)
    {
        Optional<Blog> b = blogService.findById(id);
        if(b.isPresent()) {
            return(b.toString());
        } else {
            // value is absent
            return("No object found with id ="+id);
        }	
        
    }

    @RequestMapping(value = "/pojo", method = RequestMethod.POST)
    public String insert(@Valid BlogCriteria Blogmodel)
    {
        Blog b = new Blog(Blogmodel.getTitle(), Blogmodel.getText());
        blogService.saveOrUpdateBlog(b);
        return "Hello " + Blogmodel.toString();
    }

    @PostMapping("/visualize/{sheetName}")
    // TODO Implement Global error handling
    public HttpEntity<String> viewSheetData(@RequestParam(name = "file") MultipartFile multipartFile, @PathVariable String sheetName) {
        return ResponseEntity.ok("Post mapping works");
    }
    
    @DeleteMapping(value = "/delete/{id}")
    public void deleteBlog(@PathVariable String id) {
        blogService.deleteBlog(id);
    }
}
