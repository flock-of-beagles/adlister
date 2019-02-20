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

@WebServlet(name = "controllers.SearchTestServlet", urlPatterns = "/search")
public class SearchTestServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/test.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String search = req.getParameter("tester");
//        System.out.println(search);
//        try {
//            List<Ad> results = DaoFactory.getAdsDao().findAdsbyTitleorDescription(search);
//            req.getSession().setAttribute("ads", results);
//            resp.sendRedirect("/ads");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}