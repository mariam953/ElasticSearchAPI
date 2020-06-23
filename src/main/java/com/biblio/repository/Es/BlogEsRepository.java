/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblio.repository.Es;


import com.biblio.models.BlogEs;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nafar
 */
@Repository
public interface BlogEsRepository extends ElasticsearchRepository<BlogEs, String> {
    
    Page<BlogEs> findByTitle(String name, Pageable pageable);
    
}
