package com.esliceu.PracticaFigures.controllers;

import com.esliceu.PracticaFigures.Model.User;
import com.esliceu.PracticaFigures.services.FigureServ;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/drawer")
public class Draw extends HttpServlet {
    FigureServ figureServ = new FigureServ();
    int width;
    User user;
    int posX;
    int posY;
    String type;
    String name;
    String color;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/figureForm.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User currentUser = (User) session.getAttribute("user");
        width = Integer.parseInt(req.getParameter("width"));
        type = req.getParameter("figures");
        posX = Integer.parseInt(req.getParameter("positionX"));
        posY = Integer.parseInt(req.getParameter("positionY"));
        color = req.getParameter("color");
        name = req.getParameter("figureName");
        user = currentUser;
        if (name.equals("")) {
            name = type + " " + Math.round(Math.random() * 1000);
        }
        figureServ.figureCreation(name, type, color, posX, posY, width, user);
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/figureForm.jsp");
        dispatcher.forward(req, resp);
    }
}
