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
        String emptyString = "";
        User user = (User) request.getSession().getAttribute("user");
        String holdTitle = request.getParameter("title");
        request.getSession().setAttribute("createTitle", holdTitle);
        String holdDesc = request.getParameter("description");
        request.getSession().setAttribute("createDescription", holdDesc);
        if (request.getParameter("title").equals("") || request.getParameter("description").equals("")) {
            request.getSession().setAttribute("emptyFields", 1);
            response.sendRedirect("/ads/create");
        } else {
            Ad ad = new Ad(
                    user.getId(),
                    request.getParameter("title"),
                    request.getParameter("description")
            );
            // Checkboxes only give a value if they are checked, other wise request.getParamater gives a null
            String checkbox1 = request.getParameter("checkbox1");
            String checkbox2 = request.getParameter("checkbox2");
            String checkbox3 = request.getParameter("checkbox3");
            String checkbox4 = request.getParameter("checkbox4");
            String checkbox5 = request.getParameter("checkbox5");
            String checkbox6 = request.getParameter("checkbox6");
            String checkbox7 = request.getParameter("checkbox7");
            String checkbox8 = request.getParameter("checkbox8");
            String checkbox9 = request.getParameter("checkbox9");
            String checkbox10 = request.getParameter("checkbox10");
            String checkbox11 = request.getParameter("checkbox11");
            long adIndex = DaoFactory.getAdsDao().insert(ad);
            try {
                //See comment below for CategoryInsertHelper, the returned long is the index of the inserted row (if an insert occurred)
                long result1 = CategoryInsertHelper(adIndex, checkbox1, 1);
                long result2 = CategoryInsertHelper(adIndex, checkbox2, 2);
                long result3 = CategoryInsertHelper(adIndex, checkbox3, 3);
                long result4 = CategoryInsertHelper(adIndex, checkbox4, 4);
                long result5 = CategoryInsertHelper(adIndex, checkbox5, 5);
                long result6 = CategoryInsertHelper(adIndex, checkbox6, 6);
                long result7 = CategoryInsertHelper(adIndex, checkbox7, 7);
                long result8 = CategoryInsertHelper(adIndex, checkbox8, 8);
                long result9 = CategoryInsertHelper(adIndex, checkbox9, 9);
                long result10 = CategoryInsertHelper(adIndex, checkbox10, 10);
                long result11 = CategoryInsertHelper(adIndex, checkbox11, 11);

            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.getSession().setAttribute("createTitle", emptyString);
            request.getSession().setAttribute("createDescription", emptyString);
            request.getSession().setAttribute("emptyFields", 0);
            response.sendRedirect("/ads");
            //Helper method to streamline adding categories, feed it the adIndex and the relevant checkbox value and if the checkbox was clicked it will do a table insert

        }

    }

    private long CategoryInsertHelper(long index, String category, long num) throws SQLException {
        long result;
        if (category != null) {
            long insertCat = num;
            Category cat = new Category(
                    index,
                    insertCat
            );
            result = DaoFactory.getAdsDao().insertCategory(cat);
        } else result = 0;
        return result;
    }

}
