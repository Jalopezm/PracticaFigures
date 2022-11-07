package com.esliceu.PracticaFigures.controllers;

import com.esliceu.PracticaFigures.Model.Figure;
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
import java.util.List;

@WebServlet("/userFigureList")
public class UserFigureList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        List<Figure> figureList = FigureServ.userListFigures(user);
        req.setAttribute("figure", figureList);
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/userFigureList.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
