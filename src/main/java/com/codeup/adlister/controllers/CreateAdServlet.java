package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
            .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        Ad ad = new Ad(
            user.getId(),
            request.getParameter("title"),
            request.getParameter("description")
        );
        // Checkboxes only give a value if they are checked, other wise request.getParamater gives a null
        String tester = request.getParameter("checkbox1");
        String tester2;
        tester2 = request.getParameter("checkbox2");
        System.out.println(tester);
        System.out.println(tester2);
        long adIndex = DaoFactory.getAdsDao().insert(ad);
        try {
            //See comment below for CategoryInsertHelper, the returned long is the index of the inserted column (if an insert occurred)
            long result1 = CategoryInsertHelper(adIndex, tester);
            long result2 = CategoryInsertHelper(adIndex, tester2);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/ads");
    }
    //Helper method to streamline adding categories, feed it the adIndex and the relevant checkbox value and if the checkbox was clicked it will do a table insert
    private long CategoryInsertHelper(long index, String category) throws SQLException {
        long result;
        if (category!=null){
            Category cat = new Category(
                    index,
                    category
            );
                result = DaoFactory.getAdsDao().insertCategory(cat);
        }else result = 0;
        return result;
    }
}
