package com.esliceu.PracticaFigures.controllers;

import com.esliceu.PracticaFigures.Model.User;
import com.esliceu.PracticaFigures.services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    String name;
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        name = req.getParameter("nameUser");

        if (name.equals("")) {
            req.setAttribute("error", "Error de login");
            resp.sendRedirect("/login");
            return;
        }

        User user = userService.userCreation(name);
        session.setAttribute("user", user);
        resp.sendRedirect("/drawer");


    }
}
