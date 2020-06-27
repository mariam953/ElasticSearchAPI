package com.biblio.controller;

import com.biblio.models.Book;
import com.biblio.service.BookService;
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
    private BookService bookService;
   
    //@Autowired
    //private BlogRepository repository;

    @GetMapping("/books")
    public HttpEntity<String> findAll(){
        String resp = new String();
        
        for (Book customer : bookService.findAll()) {
            resp+=customer;
        }
        
        return ResponseEntity.ok(resp);
    }
    
    @GetMapping("/findbytitle/{title}")
    public String findByTitle(@PathVariable("title") String title)
    {
        Book b = bookService.findBytitle(title);
        return b.toString();
    }
    
    @GetMapping("/findbyid/{id}")
    public String findById(@PathVariable("id") String id)
    {
        Optional<Book> b = bookService.findById(id);
        if(b.isPresent()) {
            return(b.toString());
        } else {
            // value is absent
            return("No object found with id ="+id);
        }	
        
    }

    @PutMapping(value = "/addbook")
    public String insert(@Valid BookCriteria book)
    {
        Book b = new Book(book.getIsbn(), book.getTitle(), book.getPagenbr() );
        //print(""+b.toString())
        bookService.saveOrUpdateBook(b);
        return "Hello " + book.toString();
    }
    
    @DeleteMapping(value = "/delete/{id}")
    public void deleteBlog(@PathVariable String id) {
        bookService.deleteBook(id);
    }
}
