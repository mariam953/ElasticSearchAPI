/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblio.service;


import com.biblio.models.BlogEs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author nafar
 */
@Service
public interface BlogEsService{
    
    BlogEs save(BlogEs blog);

    BlogEs findOne(String id);

    Iterable<BlogEs> findAll();


    Page<BlogEs> findByTitle(String title, PageRequest pageRequest);
    
    void deleteById(String blog);

}
