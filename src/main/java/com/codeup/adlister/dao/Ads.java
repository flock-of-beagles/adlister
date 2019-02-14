package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;

import java.sql.SQLException;
import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    List<Ad> profileFind(long profileId) throws SQLException;
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);
    Long insertCategory(Category category) throws SQLException;
}
