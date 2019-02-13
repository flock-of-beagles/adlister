package com.codeup.adlister;

public class Config {
    private String url = "jdbc:mysql://localhost/adlister_db";
    private String user = "adlister_user";
    private String password = "password123";
    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
