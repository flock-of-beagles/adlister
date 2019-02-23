package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    List<Ad> profileFind(long profileId) throws SQLException;
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);
    Long insertCategory(Category category) throws SQLException;
    Ad findAdbyID (long AdId) throws SQLException;
    List<Long> findCategoriesbyID (long ad_id) throws SQLException;
    void editAd (Ad ad, long id) throws SQLException;
    void deleteCategories (long ad_id);
    void deleteAd (long id);
    List<Ad> findAdsbyTitleorDescription(String search) throws SQLException;
    List<Ad> findAdsByCategories (List<Long> categories) throws SQLException;
    List<Ad> findAdsByCategory (long category) throws SQLException;
}
