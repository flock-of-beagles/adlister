package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
            .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Ad ad = new Ad(
            1, // for now we'll hardcode the user id
            request.getParameter("title"),
            request.getParameter("description")
        );
        // Checkboxes only give a value if they are checked, other wise request.getParamater gives a null
        //TODO Write the MYSQL you lazy asshole
        String tester = request.getParameter("checkbox1");
        String tester2;
        tester2 = request.getParameter("checkbox2");
        System.out.println(tester);
        System.out.println(tester2);
        long test = DaoFactory.getAdsDao().insert(ad);
        if (tester!=null){
            Category category = new Category(
                    test,
                    tester
            );

        }
        System.out.println(test);
        response.sendRedirect("/ads");
    }
}
