package com.codeup.adlister.dao;

import com.codeup.adlister.Config;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;
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

    public void editAd(Ad ad, long id) throws SQLException {
        String editQuery = "UPDATE ads SET title = ?, description = ? WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(editQuery, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, ad.getTitle());
        stmt.setString(2, ad.getDescription());
        stmt.setLong(3, id);
        stmt.executeUpdate();
    }

    //Like insert but for the categories table
    //Takes in a category object, breaks it down and then insterts it into the categories table
    //Returns a long that corresponds with the index of the row it insterted its query into
    public Long insertCategory(Category category) throws SQLException {
        String insertQuery = "INSERT INTO ads_categories (ad_id, ad_category) VALUES (?, ?)";
        PreparedStatement ps = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
        ps.setLong(1, category.getAd_id());
        ps.setLong(2, category.getCategory());
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
    public Ad findAdbyID(long adId) throws SQLException {
        String searchQuery = "SELECT * from ads WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(searchQuery);
        stmt.setLong(1, adId);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        return extractAd(rs);
    }

    //Given an ad_id this method will return all categories that ad has as a List<String>
    public List<Long> findCategoriesbyID(long ad_id) throws SQLException {
        List<Long> categories = new ArrayList<>();
        String searchQuery = "SELECT * FROM ads_categories where ad_id = ?";
        PreparedStatement stmt = connection.prepareStatement(searchQuery);
        stmt.setLong(1, ad_id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            long hold = rs.getLong("ad_category");
            categories.add(hold);
        }
        return categories;
    }

    public List<Ad> findAdsByCategories (List<Long> categories) throws SQLException {
        String search = categories.toString();
        search = search.replaceAll("\\[", "(").replaceAll("\\]",")");
        String searchQuery = "SELECT ads.id, ads.user_id, ads.title, ads.description FROM ads JOIN ads_categories ON ads.id = ads_categories.ad_id WHERE ads_categories.ad_category in ? GROUP BY ads_categories.ad_id";
        PreparedStatement stmt = connection.prepareStatement(searchQuery);
        stmt.setString(1,search);
        ResultSet rs = stmt.executeQuery();
        return createAdsFromResults(rs);
    }
    public List<Ad> findAdsByCategories (long category) throws SQLException {
        String searchQuery = "SELECT ads.id, ads.user_id, ads.title, ads.description FROM ads JOIN ads_categories ON ads.id = ads_categories.ad_id WHERE ads_categories.ad_category = ? GROUP BY ads_categories.ad_id";
        PreparedStatement stmt = connection.prepareStatement(searchQuery);
        stmt.setLong(1,category);
        ResultSet rs = stmt.executeQuery();
        return createAdsFromResults(rs);
    }

    public void deleteCategories(long ad_id) {
        try {
            System.out.println("deleteCategories");
            String deleteQuery = "DELETE FROM ads_categories WHERE ad_id = ?";
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(deleteQuery);
            stmt.setLong(1, ad_id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAd(long deleteId) {
        try {
            String deleteQuery = "DELETE FROM ads WHERE id = ?";
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(deleteQuery);
            stmt.setLong(1, deleteId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }

    public List<Ad> findAdsbyTitleorDescription(String search) throws SQLException {
        search = "%"+search+"%";
        System.out.println(search);
        String searchQuery = "SELECT * FROM ads WHERE title like ? OR description like ?";
        PreparedStatement stmt = connection.prepareStatement(searchQuery);
        stmt.setString(1, search);
        stmt.setString(2, search);
        ResultSet rs = stmt.executeQuery();
        return createAdsFromResults(rs);
    }
}

