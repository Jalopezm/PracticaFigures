package com.esliceu.PracticaFigures.controllers;

import com.esliceu.PracticaFigures.DAO.FigureDAO;
import com.esliceu.PracticaFigures.services.FigureServ;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/deleteConfirm")
public class DeleteConfirm  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/deleteConfirm.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int figureId = (int) session.getAttribute("figureID");
        String confirm = req.getParameter("confirm");
        if (confirm.equals("Yes")){
            new FigureServ().deleteFigureById(figureId);
            RequestDispatcher dispatcher =
                    req.getRequestDispatcher("/WEB-INF/jsp/deleted.jsp");
            dispatcher.forward(req, resp);
        }else{
            resp.sendRedirect("/figureList");
        }
    }
}
