package com.esliceu.PracticaFigures.controllers;

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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String pass = req.getParameter("pass");

        String userR = req.getParameter("userR");
        String passR = req.getParameter("passR");
        if (user != null && userR == null) {
            if (user.equals("liceu") && pass.equals("1234")) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                resp.sendRedirect("/figureForm");
                return;
            } else {
                req.setAttribute("msg", "Wrorg User Or Password");
            }
        }else if (userR != null && user == null){
            HttpSession session = req.getSession();
            session.setAttribute("user", userR);
            resp.sendRedirect("/figureForm");
            return;
        }
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        dispatcher.forward(req, resp);
    }
}
