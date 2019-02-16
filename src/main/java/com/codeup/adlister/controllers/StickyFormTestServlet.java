package com.codeup.adlister.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.StickyFromTestServlet", urlPatterns = "/test")
public class StickyFormTestServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tester = request.getParameter("test");
        if (tester == null) {
            System.out.println("Test string had no value");
            request.getSession().setAttribute("test", tester);
        }
        request.getRequestDispatcher("/WEB-INF/test.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String validate = req.getParameter("tester");
        if (validate.equals("Yes")){
            resp.sendRedirect("/success");
        }
        else{
            System.out.println("String was " + validate);
            req.getSession().setAttribute("tester", validate);
            resp.sendRedirect("/test");
        }
    }
}

