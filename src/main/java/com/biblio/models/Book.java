package com.biblio.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Book")
public class Book {
    @Id
    public  String id;
    
    public  String title;
    public  String isbn;
    public  int pagenbr;

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

    
    public Book(){ }
    
       
    public Book(String isbn, String title, int pagenbr){
        this.isbn=isbn;
        this.title=title;
        this.pagenbr = pagenbr ;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", isbn=" + isbn + ", pagenbr=" + pagenbr + '}';
    }
    
    
}