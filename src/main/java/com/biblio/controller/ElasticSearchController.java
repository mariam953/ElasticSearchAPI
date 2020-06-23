package com.biblio.controller;

import com.biblio.models.Blog;
import com.biblio.models.BlogEs;
import com.biblio.repository.Es.BlogEsRepository;
import com.biblio.service.BlogEsService;
import com.biblio.service.BlogService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/es")
@CrossOrigin("*")
public class ElasticSearchController {
    
    @Autowired
    private BlogService blogService;
   
    @Autowired
    private BlogEsService blogEsService;
   
    //@Autowired
    //private BlogRepository repository;

    @GetMapping("/blogs")
    public HttpEntity<String> hello(){
        
        String resp=new String();
        
        List<BlogEs> blogs = (List<BlogEs>) blogEsService.findAll();
        for (BlogEs customer : blogs) {
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
