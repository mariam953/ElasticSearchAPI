package com.biblio.service;

import com.biblio.models.Book;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public interface BookService {

    List<Book> findAll();
    
    Optional<Book> findById(String id);

    Book findBytitle(String title);

    Book findByIsbn(String isbn);

    void saveOrUpdateBook(Book book);

    void deleteBook(String id);

}