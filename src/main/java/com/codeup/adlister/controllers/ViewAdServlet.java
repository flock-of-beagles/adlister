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
//TODO Finish this servlet and associated JSP
//TODO Make this unreachable unless you are coming from an ad link
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
        System.out.println(id);
        //Testing code, demonstrates ability to retirve an ID and find specific ad as well as it's categories
        Ad specAd = null;
        List<String> testList = null;
        try {
            specAd = DaoFactory.getAdsDao().findAdbyID(id);
            System.out.println(specAd.getTitle());
            testList = DaoFactory.getAdsDao().findCategoriesbyID(id);
            for (String category : testList){
                System.out.println(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("/WEB-INF/ads/viewAd.jsp").forward(request, response);
    }
}
