package com.codeup.adlister.models;

public class Category {
    private long id;
    private long ad_id;
    private String category;

    public Category (long ad_id, String category){
        this.ad_id = ad_id;
        this.category = category;
    }

    public long getAd_id(){
        return ad_id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory (){
        return category;
    }
}
