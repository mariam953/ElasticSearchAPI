package com.biblio.models;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "library.book",indexStoreType="_doc", createIndex = false)
public class BookEs {
    @Id
    public  String id;
    
    public  String title;
    public  String isbn;
    public  int pagenbr;
    
    public BookEs(){ }

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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPagenbr() {
        return pagenbr;
    }

    public void setPagenbr(int pagenbr) {
        this.pagenbr = pagenbr;
    }

    @Override
    public String toString() {
        return "BookEs{" + "id=" + id + ", title=" + title + ", isbn=" + isbn + ", pagenbr=" + pagenbr + '}';
    }

   
}