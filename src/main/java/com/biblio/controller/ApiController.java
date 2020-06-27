package com.biblio.controller;

import com.biblio.models.Book;
import com.biblio.models.BookEs;
import com.biblio.service.BookEsService;
import com.biblio.service.BookService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/api")
@CrossOrigin("*")

public class ApiController {
    
    @Autowired
    private BookEsService bookEsService;

    @Autowired
    private BookService bookService;
    
    @GetMapping("/getallbooks")
    public List<BookEs> findAll(){
        try {
            Iterable<BookEs> books = bookEsService.findAll();
            List<BookEs> BooksList = new ArrayList<>();
            for (BookEs item : books) {
                BooksList.add(item);
            }

            return BooksList;
        } catch (Exception e) {
            return null;
        }
    }
    
    @GetMapping("/findbookbyid/{id}")
    public String findById(@PathVariable("id") String id)
    {
        BookEs b = bookEsService.findOne(id);
        if(b == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book with id "+id+" not found in ES cluster");	        
        }
        return b.toString();	

    }
    
    @GetMapping("/findbookbyisbn/{isbn}")
    public List<BookEs> findByIsbn(@PathVariable("isbn") String isbn)
    {
        try {
            Iterable<BookEs> books = bookEsService.findByIsbn(isbn, PageRequest.of(0, 5000));
            List<BookEs> BooksList = new ArrayList<>();
            for (BookEs item : books) {
                BooksList.add(item);
            }

            return BooksList;
        } catch (Exception e) {
            return null;
        }
        
    }

    @PutMapping(value = "/addbook")
    public ResponseEntity<String> addBook(@RequestBody BookCriteria book)
    {
        System.out.println("received object"+book.toString());
        Book b = new Book(book.getIsbn(), book.getTitle(), book.getPagenbr() );
        System.out.println("b object"+b.toString());
        bookService.saveOrUpdateBook(b);
        return ResponseEntity.ok("Insert successfull");
    }
    
    @DeleteMapping(value = "/deletebook/{id}")
    public void deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
    }
}
