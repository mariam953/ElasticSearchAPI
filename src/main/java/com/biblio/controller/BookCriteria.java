/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblio.controller;

class BookCriteria {
 
    public  String id;
    public  String title;
    public  String isbn;
    public  int pagenbr;
   
   BookCriteria() {
   }

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
        return "BookCriteria{" + "id=" + id + ", title=" + title + ", isbn=" + isbn + ", pagenbr=" + pagenbr + '}';
    }


   
}
