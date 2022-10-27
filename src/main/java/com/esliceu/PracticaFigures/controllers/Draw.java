package com.esliceu.PracticaFigures.controllers;

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
    int width;
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
        width = Integer.parseInt(req.getParameter("width"));
        type = req.getParameter("figures");
        posX = Integer.parseInt(req.getParameter("positionX"));
        posY = Integer.parseInt(req.getParameter("positionY"));
        color = req.getParameter("color");
        name = req.getParameter("figureName");
        HttpSession session = req.getSession();

        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/figureForm.jsp");
        dispatcher.forward(req, resp);
    }
}
