package com.esliceu.PracticaFigures.controllers;

import com.esliceu.PracticaFigures.Model.Figure;
import com.esliceu.PracticaFigures.services.FigureServ;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/figureView")
public class FigureView extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/figureView.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int figureId = Integer.parseInt(req.getParameter("figureId"));
        Figure figure = new FigureServ().getFigureById(figureId);
        req.setAttribute("figure", figure);
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/figureView.jsp");
        dispatcher.forward(req, resp);
    }
}
