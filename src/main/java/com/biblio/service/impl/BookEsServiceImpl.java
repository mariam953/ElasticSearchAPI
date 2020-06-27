/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblio.service.impl;


import com.biblio.models.BookEs;
import com.biblio.repository.Es.BookEsRepository;
import com.biblio.service.BookEsService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author nafar
 */
@Service
public class BookEsServiceImpl implements BookEsService {

    @Autowired
    private BookEsRepository bookRepository;
    
    @Override
    public BookEs save(BookEs book){
        return bookRepository.save(book);
    }
    
    @Override
    public BookEs findOne(String id) {
        
        Optional<BookEs> b = bookRepository.findById(id);
        if(b.isPresent()) {
            return(b.get());
        } else {
            return(null);
        }	
    }

    @Override
    public Iterable<BookEs> findAll() {
       return bookRepository.findAll();
    }

    @Override
    public Page<BookEs> findByTitle(String title, PageRequest pageRequest) {
        return bookRepository.findByTitle(title, pageRequest);
    }

    @Override
    public Page<BookEs> findByIsbn(String isbn, PageRequest pageRequest) {
        return bookRepository.findByIsbn(isbn, pageRequest);
    }
    
    
}
