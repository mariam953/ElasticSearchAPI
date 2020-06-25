package com.biblio.models;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "forum.blog",indexStoreType="_doc", createIndex = false)
//@Document(indexName = "forum",indexStoreType="Blog", createIndex = false)
public class BlogEs {
    @Id
    private String id;
    
    private String title;
    private String body;
    
    public BlogEs(){ }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    
    
    public BlogEs(String title, String body){
        this.title=title;
        this.body=body;
    }
    
    @Override
    public String toString() {
        return "Blog{" + "id=" + id + ", title=" + title + ", body=" + body + '}';
    }
}