package com.codeup.adlister.controllers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.LogoutServlet", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("user");
        boolean editMessage = false;
        if (request.getSession().getAttribute("editSuc")!=null){
            System.out.println("editSuc true");
            editMessage = true;
        }
        request.getSession().invalidate();
        if (editMessage){
            response.sendRedirect("/login?editValid=1");
        }else {
            response.sendRedirect("/login");
        }
    }
}
