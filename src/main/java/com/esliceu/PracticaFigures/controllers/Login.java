package com.esliceu.PracticaFigures.controllers;

import com.esliceu.PracticaFigures.services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    String name;
    String pass;
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        name = req.getParameter("name");
        pass = req.getParameter("pass");

        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        if (name.equals("")){
            resp.sendRedirect("/login");
        }else if (pass.equals("")){
            resp.sendRedirect("/login");
        }
        userService.userCreation(name,pass);
        resp.sendRedirect("/drawer");

    }
}
