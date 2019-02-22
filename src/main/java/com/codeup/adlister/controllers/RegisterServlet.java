package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
        } else {
            System.out.println(request.getSession().getAttribute("duplicate"));
            request.setAttribute("passItOn", request.getSession().getAttribute("duplicate"));
            request.getSession().removeAttribute("duplicate");
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

        // validate input
        boolean inputHasErrors = username.isEmpty()
            || email.isEmpty()
            || password.isEmpty()
            || (! password.equals(passwordConfirmation));

        if (inputHasErrors) {
            response.sendRedirect("/register");
            return;
        }
        try {
            boolean userCheck = DaoFactory.getUsersDao().userCheck(username);
            System.out.println("Here is the user check" + userCheck);
            if (userCheck){
                request.getSession().setAttribute("duplicate", 1);
                response.sendRedirect("/register");
            }else {
                User user = new User(username, email, Password.hash(password));
                DaoFactory.getUsersDao().insert(user);
                response.sendRedirect("/login");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // create and save a new user

    }
}
