package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "controllers.EditAdServlet", urlPatterns = "/ads/edit")
public class EditAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long editID = Long.parseLong(request.getParameter("editID"));
        Ad ad = null;
        try {
            ad = DaoFactory.getAdsDao().findAdbyID(editID);
            System.out.println(ad.getDescription());
            request.setAttribute("editAD", ad);
            request.getRequestDispatcher("/WEB-INF/ads/edit.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        long editID = Long.parseLong(request.getParameter("IDEdit"));
        System.out.println(editID);
        Ad ad = new Ad(
                user.getId(),
                request.getParameter("title"),
                request.getParameter("description")
        );
        try {
            long result = DaoFactory.getAdsDao().editAd(ad, editID);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/profile");
    }
}


