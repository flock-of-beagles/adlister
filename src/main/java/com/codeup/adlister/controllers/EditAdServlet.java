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
        request.getSession().setAttribute("editIDRec", editID);
        Ad ad = null;
        try {
            ad = DaoFactory.getAdsDao().findAdbyID(editID);
            if (request.getSession().getAttribute("editTitle")==null){
                request.getSession().setAttribute("editTitle", ad.getTitle());
            }
            if (request.getSession().getAttribute("editDescription")==null){
                request.getSession().setAttribute("editDescription", ad.getDescription());
            }
            request.setAttribute("editTitle", ad.getTitle());
            request.setAttribute("editDescription", ad.getDescription());
            request.setAttribute("editAD", ad);
            List<Long> categories = null;
            categories = DaoFactory.getAdsDao().findCategoriesbyID(editID);
            if (categories.contains(1L)){
                request.getSession().setAttribute("category1", 1);
            }
            if (categories.contains(2L)){
                request.getSession().setAttribute("category2", 1);
            }
            request.getSession().setAttribute("testList", categories);
            request.getRequestDispatcher("/WEB-INF/ads/edit.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        long editID = Long.parseLong(request.getParameter("IDEdit"));
        System.out.println(editID);
        String editTitle = request.getParameter("editTitle");
        String editDescription = request.getParameter("editDescription");
        if (editTitle.equals("") || editDescription.equals("")) {
            request.getSession().setAttribute("emptyField", 1);
            long editIDRec = Long.parseLong(request.getParameter("IDEdit"));
            response.sendRedirect("/ads/edit?editID="+editIDRec);
        } else {
            Ad ad = new Ad(
                    user.getId(),
                    request.getParameter("editTitle"),
                    request.getParameter("editDescription")
            );
            try {
                long result = DaoFactory.getAdsDao().editAd(ad, editID);
                request.getSession().setAttribute("editTitle", null);
                request.getSession().setAttribute("editDescription", null);

            } catch (SQLException e) {
                e.printStackTrace();
            }
            response.sendRedirect("/profile");
        }
    }
}


