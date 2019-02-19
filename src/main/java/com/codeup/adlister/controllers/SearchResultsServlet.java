package com.codeup.adlister.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.SearchResultsServlet", urlPatterns = "/search")
public class SearchResultsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/test.jsp").forward(request, response);
        request.setAttribute("SearchAds", request.getSession().getAttribute("ads"));
        request.getRequestDispatcher("/WEB-INF/ads/searchResults.jsp")
                .forward(request, response);
    }
}
