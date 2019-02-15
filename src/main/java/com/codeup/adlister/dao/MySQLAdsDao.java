package com.codeup.adlister.dao;
import com.codeup.adlister.Config;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }
    //Given an user_id to look for, this method will return all ads made by that user
    public List<Ad> profileFind(long profileID) throws SQLException {
        PreparedStatement stmt;
        stmt = connection.prepareStatement("SELECT * FROM ads WHERE user_id = ?");
        stmt.setLong(1, profileID);
        ResultSet rs = stmt.executeQuery();
        return createAdsFromResults(rs);
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    //Like insert but for the categories table
    //Takes in a category object, breaks it down and then insterts it into the categories table
    //Returns a long that corresponds with the index of the row it insterted its query into
    public Long insertCategory (Category category) throws SQLException {
        String insertQuery = "INSERT INTO categories(ad_id, category) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, category.getAd_id());
            ps.setString(2, category.getCategory());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
        return rs.getLong(1);
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description")
        );
    }
    //Given an ID this method will return that specific ad
    public Ad findAdbyID (long adId) throws SQLException {
        String searchQuery = "SELECT * from ads WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(searchQuery);
        stmt.setLong(1,adId);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        return extractAd(rs);
    }
    //Given an ad_id this method will return all categories that ad has as a List<String>
    public List<String> findCategoriesbyID (long ad_id) throws SQLException {
        List<String> categories = new ArrayList<>();
        String searchQuery = "SELECT * FROM categories where ad_id = ?";
        PreparedStatement stmt = connection.prepareStatement(searchQuery);
        stmt.setLong(1, ad_id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            String hold = rs.getString("category");
            categories.add(hold);
        }
        return categories;
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }
}
