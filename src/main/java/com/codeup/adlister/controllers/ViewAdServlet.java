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
import java.util.ArrayList;
import java.util.List;
//TODO Finish this servlet and associated JSP
//This servlet displays specific ads, only way to reach this should be to click a link on an ad
@WebServlet(name = "controllers.ViewAdServlet", urlPatterns = "/ads/view")
public class ViewAdServlet extends HttpServlet {
//    List<Ad> testAds = new ArrayList<>();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("id")==null){
            response.sendRedirect("/ads");
        }
        //This long comes from the ads/index.jsp anchor links
        long id = Long.parseLong(request.getParameter("id"));
        //Testing code, demonstrates ability to retirve an ID and find specific ad as well as it's categories
        Ad specAd = null;
        List<Long> categories = null;
        try {
            specAd = DaoFactory.getAdsDao().findAdbyID(id);
            long userID = specAd.getUserId();
            System.out.println("User ID is " + userID);
            User user = DaoFactory.getUsersDao().findById(userID);
            System.out.println(user.getUsername());
            request.setAttribute("user", user);
            request.getSession().setAttribute("specAd", specAd);
            categories = DaoFactory.getAdsDao().findCategoriesbyID(id);
            if (categories.contains(1L)){
                request.setAttribute("category1", 1);
            }
            if (categories.contains(2L)){
                request.setAttribute("category2", 1);
            }
            if (categories.contains(3L)){
                request.setAttribute("category3", 1);
            }
            if (categories.contains(4L)){
                request.setAttribute("category4", 1);
            }
            if (categories.contains(5L)){
                request.setAttribute("category5", 1);
            }
            if (categories.contains(6L)){
                request.setAttribute("category6", 1);
            }
            if (categories.contains(7L)){
                request.setAttribute("category7", 1);
            }
            if (categories.contains(8L)){
                request.setAttribute("category8", 1);
            }
            if (categories.contains(9L)){
                request.setAttribute("category9", 1);
            }
            if (categories.contains(10L)){
                request.setAttribute("category10", 1);
            }
            if (categories.contains(11L)){
                request.setAttribute("category11", 1);
            }
            request.getSession().setAttribute("testList", categories);
            for (long category : categories){
                System.out.println(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("/WEB-INF/ads/viewAd.jsp").forward(request, response);
    }
}
