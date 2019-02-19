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
            try {
                DaoFactory.getAdsDao().editAd(ad, editID);
                System.out.println(editID);
                DaoFactory.getAdsDao().deleteCategories(editID);
                long result1 = CategoryInsertHelper(editID, checkbox1, 1);
                long result2 = CategoryInsertHelper(editID, checkbox2, 2);
                long result3 = CategoryInsertHelper(editID, checkbox3, 3);
                long result4 = CategoryInsertHelper(editID, checkbox4, 4);
                long result5 = CategoryInsertHelper(editID, checkbox5, 5);
                long result6 = CategoryInsertHelper(editID, checkbox6, 6);
                long result7 = CategoryInsertHelper(editID, checkbox7, 7);
                long result8 = CategoryInsertHelper(editID, checkbox8, 8);
                long result9 = CategoryInsertHelper(editID, checkbox9, 9);
                long result10 = CategoryInsertHelper(editID, checkbox10, 10);
                long result11 = CategoryInsertHelper(editID, checkbox11, 11);
                request.getSession().setAttribute("editTitle", null);
                request.getSession().setAttribute("editDescription", null);

            } catch (SQLException e) {
                e.printStackTrace();
            }
            response.sendRedirect("/profile");

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


