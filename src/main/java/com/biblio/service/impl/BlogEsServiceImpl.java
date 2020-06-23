/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblio.service.impl;


import com.biblio.models.BlogEs;
import com.biblio.repository.Es.BlogEsRepository;
import com.biblio.service.BlogEsService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author nafar
 */
@Service
public class BlogEsServiceImpl implements BlogEsService {

    @Autowired
    private BlogEsRepository blogRepository;
    
    @Override
    public BlogEs findOne(String id) {
        
        Optional<BlogEs> b = blogRepository.findById(id);
        if(b.isPresent()) {
            return(b.get());
        } else {
            // value is absent
            return(null);
        }	
    }

    @Override
    public Iterable<BlogEs> findAll() {
       return blogRepository.findAll();
    }

    @Override
    public Page<BlogEs> findByTitle(String title, PageRequest pageRequest) {
        return blogRepository.findByTitle(title, pageRequest);
    }
   
    
}
