package com.biblio.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Blog")
public class Blog {
    @Id
    private String id;
    
    private String title;
    private String body;
    
    public Blog(){ }
    
    public Blog(String title, String body){
        this.title=title;
        this.body=body;
    }
    
    @Override
    public String toString() {
        return "Blog{" + "id=" + id + ", title=" + title + ", body=" + body + '}';
    }
}