/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblio.controller;

class BlogCriteria {
 
   private int _id;
   private String title;
   private String text;
   
   BlogCriteria() {
   }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    
    public int get_Id() {
        return _id;
    }

    public void set_Id(int _id) {
        this._id = _id;
    }

    @Override
    public String toString() {
        return "BlogCriteria{" + "_id=" + _id + ", title=" + title + ", text=" + text + '}';
    }
    
}
