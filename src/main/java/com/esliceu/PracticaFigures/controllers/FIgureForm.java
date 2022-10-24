package com.esliceu.PracticaFigures.controllers;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/figureForm")
public class FIgureForm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String user = (String) session.getAttribute("user");
        if (user == null){
            resp.setStatus(401);
            PrintWriter pw = resp.getWriter();
            pw.println("NO AUTORIZADO");
            return;
        }else {
            req.setAttribute("msg", "Hello "+user);
            RequestDispatcher dispatcher =
                    req.getRequestDispatcher("/WEB-INF/jsp/figureForm.jsp");
            dispatcher.forward(req, resp);
        }
    }

}
