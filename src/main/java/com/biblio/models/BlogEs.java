package com.biblio.models;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "forum",indexStoreType="Blog", createIndex = false)
public class BlogEs {
    @Id
    private String _id;
    
    private String title;
    private String body;
    
    public BlogEs(){ }
    
    public BlogEs(String title, String body){
        this.title=title;
        this.body=body;
    }
    
    @Override
    public String toString() {
        return "Blog{" + "id=" + _id + ", title=" + title + ", body=" + body + '}';
    }
}