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

@WebServlet(name = "controllers.DeleteAdServlet", urlPatterns = "/delete")
public class DeleteAdServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("deleteID") == null) {
            response.sendRedirect("/ads");
        } else {
            long deleteID = Long.parseLong(request.getParameter("deleteID"));
            System.out.println(deleteID);
            User user = (User) request.getSession().getAttribute("user");
            Ad check = null;
            try {
                check = DaoFactory.getAdsDao().findAdbyID(deleteID);
                if (user.getId()!=check.getUserId()){
                    response.sendRedirect("/profile");
                }else {
                    DaoFactory.getAdsDao().deleteCategories(deleteID);
                    DaoFactory.getAdsDao().deleteAd(deleteID);
                    response.sendRedirect("/profile");
                }
            } catch (SQLException e) {
                response.sendRedirect("/profile");
            }


        }
    }
}