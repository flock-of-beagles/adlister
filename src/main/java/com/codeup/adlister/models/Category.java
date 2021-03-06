package com.codeup.adlister.models;
// This constuctor is used to make objects to feed into the Categories table
public class Category {
    private long id;
    private long ad_id;
    private long category;

    public Category (long ad_id, long category){
        this.ad_id = ad_id;
        this.category = category;
    }
// Getters and setters for dealing with category objects
    public long getAd_id(){
        return ad_id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCategory (){
        return category;
    }
}
