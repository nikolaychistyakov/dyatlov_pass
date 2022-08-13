package com.xyc;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "IndexServlet", value = "/start")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        if(httpSession.getAttribute("name") == null) {
            httpSession.setAttribute("name", null);
            httpSession.setAttribute("exp", 0);
            httpSession.setAttribute("act", 0);
            getServletContext().getRequestDispatcher("/start.jsp").forward(req, resp);
        } else {
            getServletContext().getRequestDispatcher("/act.jsp").forward(req, resp);
        }
    }
}
