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
import java.util.List;


@WebServlet("/figureList")
public class FigureList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Figure> figureList = FigureServ.listFigures();
        req.setAttribute("figure", figureList);
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/figureList.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/figureList.jsp");
        dispatcher.forward(req, resp);
    }
}
