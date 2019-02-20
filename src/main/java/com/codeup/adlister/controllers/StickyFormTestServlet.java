package com.codeup.adlister.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.StickyFromTestServlet", urlPatterns = "/stickytest")
public class StickyFormTestServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/test.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String validate = req.getParameter("tester");
        if (validate.equals("Yes")){
            req.getSession().setAttribute("check", 0);
            resp.sendRedirect("/success");
        }
        else{
            req.getSession().setAttribute("check",1);
            System.out.println("String was " + validate);
            req.getSession().setAttribute("tester", validate);
            resp.sendRedirect("/test");
        }
    }
}

