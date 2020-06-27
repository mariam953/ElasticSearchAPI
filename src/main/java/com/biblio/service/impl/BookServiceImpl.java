package com.biblio.service.impl;

import com.biblio.models.Book;
import com.biblio.repository.Mongo.BookRepository;
import com.biblio.service.BookService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findBytitle(String title) {
         return bookRepository.findBytitle(title);
    }

    @Override
    public Book findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }
    
    @Override
    public void saveOrUpdateBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> findById(String id) {
        return bookRepository.findById(id);        
    }

}