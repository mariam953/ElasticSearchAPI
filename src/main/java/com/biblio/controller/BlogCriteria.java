/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblio.controller;

class BlogCriteria {
 
   private int _id;
   private String title;
   private String body;
   
   BlogCriteria() {
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
    
    public int get_Id() {
        return _id;
    }

    public void set_Id(int _id) {
        this._id = _id;
    }

    @Override
    public String toString() {
        return "BlogCriteria{" + "_id=" + _id + ", title=" + title + ", body=" + body + '}';
    }

    
}
