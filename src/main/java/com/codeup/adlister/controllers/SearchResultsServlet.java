package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "controllers.SearchResultsServlet", urlPatterns = "/search")
public class SearchResultsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/ads");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search-cust");
        try {
            List<Ad> results = DaoFactory.getAdsDao().findAdsbyTitleorCategory(search);
            request.getSession().setAttribute("ads", results);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("SearchAds", request.getSession().getAttribute("ads"));
        request.getRequestDispatcher("/WEB-INF/ads/searchResults.jsp")
                .forward(request, response);
    }
}
