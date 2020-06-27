/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblio.service;


import com.biblio.models.BookEs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author nafar
 */
@Service
public interface BookEsService{
    
    BookEs save(BookEs book);

    BookEs findOne(String id);

    Iterable<BookEs> findAll();


    Page<BookEs> findByTitle(String title, PageRequest pageRequest);
    
    Page<BookEs> findByIsbn(String isbn, PageRequest pageRequest);
    

}
