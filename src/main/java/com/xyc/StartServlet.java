package com.xyc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "StartServlet", value = "/go")
public class StartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession httpSession = req.getSession();
        String name = req.getParameter("name");
        if(!name.equals("")) {
            httpSession.setAttribute("name", name);
        } else {
            getServletContext().getRequestDispatcher("/start.jsp").forward(req, resp);
        }

        if (httpSession.getAttribute("name") != null) {
            httpSession.setAttribute("exp", 0);
            httpSession.setAttribute("act", 1);
            getServletContext().getRequestDispatcher("/act.jsp").forward(req, resp);
        } else {
            getServletContext().getRequestDispatcher("/start.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
