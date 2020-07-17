package com.codeup.adlister;

public class Config {
    private String url = "jdbc:mysql://localhost/refactor_test";
    private String user = "refactor_user";
    private String password = "supersecret";
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
