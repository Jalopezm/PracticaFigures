package com.esliceu.PracticaFigures.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns = "/private/*")
public class LoginFilters extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        String user = (String) session.getAttribute("user");

        if (user == null) {
            res.setStatus(401);
            PrintWriter pw = res.getWriter();
            pw.println("NO AUTORIZADO Filtro");
            return;
        }
        chain.doFilter(req, res);
    }
}