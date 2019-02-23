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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "controllers.SearchResultsServlet", urlPatterns = "/search/result")
public class SearchResultsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int searchCheck = Integer.parseInt(request.getParameter("SearchID"));
        if (searchCheck==1){
            long hold = 10;
            try {
                List<Ad> results = DaoFactory.getAdsDao().findAdsByCategory(hold);
                request.getSession().setAttribute("ads", results);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute("SearchAds", request.getSession().getAttribute("ads"));
            request.getRequestDispatcher("/WEB-INF/ads/searchResults.jsp")
                    .forward(request, response);
        } else if (searchCheck==2){
            long hold = 11;
            try {
                List<Ad> results = DaoFactory.getAdsDao().findAdsByCategory(hold);
                request.getSession().setAttribute("ads", results);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute("SearchAds", request.getSession().getAttribute("ads"));
            request.getRequestDispatcher("/WEB-INF/ads/searchResults.jsp")
                    .forward(request, response);
        } else {
            response.sendRedirect("/ads");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("search-cust") != null) {
            String search = request.getParameter("search-cust");
            try {
                List<Ad> results = DaoFactory.getAdsDao().findAdsbyTitleorDescription(search);
                request.getSession().setAttribute("ads", results);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute("SearchAds", request.getSession().getAttribute("ads"));
            request.setAttribute("search-cust",null);
            request.getRequestDispatcher("/WEB-INF/ads/searchResults.jsp")
                    .forward(request, response);
        }else if (request.getParameter("search")!=null){
            String search = request.getParameter("search");
            try {
                List<Ad> results = DaoFactory.getAdsDao().findAdsbyTitleorDescription(search);
                request.getSession().setAttribute("ads", results);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute("SearchAds", request.getSession().getAttribute("ads"));
            request.setAttribute("search-cust",null);
            request.getRequestDispatcher("/WEB-INF/ads/searchResults.jsp")
                    .forward(request, response);
        }else {
            List<Long> categories = new ArrayList<>();
            if (request.getParameter("checkbox1") != null){
                System.out.println("CHECKED");
                categories.add(1L);
            }
            if (request.getParameter("checkbox2") != null){
                categories.add(2L);
            }
            if (request.getParameter("checkbox3") != null){
                categories.add(3L);
            }
            if (request.getParameter("checkbox4") != null){
                categories.add(4L);
            }
            if (request.getParameter("checkbox5") != null){
                categories.add(5L);
            }
            if (request.getParameter("checkbox6") != null){
                categories.add(6L);
            }
            if (request.getParameter("checkbox7") != null){
                categories.add(7L);
            }
            if (request.getParameter("checkbox8") != null){
                categories.add(8L);
            }
            if (request.getParameter("checkbox9") != null){
                categories.add(9L);
            }
            if (request.getParameter("checkbox10") != null){
                categories.add(10L);
            }
            if (request.getParameter("checkbox11") != null){
                categories.add(11L);
            }
            try {
                System.out.println(categories);
                List<Ad> results = DaoFactory.getAdsDao().findAdsByCategories(categories);
                request.getSession().setAttribute("ads", results);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute("SearchAds", request.getSession().getAttribute("ads"));
            request.setAttribute("search",null);
            request.getRequestDispatcher("/WEB-INF/ads/searchResults.jsp")
                    .forward(request, response);
        }
    }
}
