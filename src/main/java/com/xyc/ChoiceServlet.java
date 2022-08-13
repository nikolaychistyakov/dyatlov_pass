package com.xyc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        name = "ChoiceServlet",
        urlPatterns = "/choiceAct"
)
public class ChoiceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession httpSession = req.getSession();
        if (httpSession.getAttribute("name") != null) {

            String action = req.getParameter("action");
            String act = req.getParameter("act");

            if (action.equals("next")) {
                int a = Integer.parseInt(act);
                httpSession.setAttribute("act", ++a);
                httpSession.setAttribute("exp", (int) httpSession.getAttribute("exp") + 5);
                if(a > 7) {
                    getServletContext().getRequestDispatcher("/end.jsp").forward(req, resp);
                } else {
                    getServletContext().getRequestDispatcher("/act.jsp").forward(req, resp);
                }
            } else if (action.equals("void")) {
                getServletContext().getRequestDispatcher("/die.jsp").forward(req, resp);
            } else {
                getServletContext().getRequestDispatcher("/happy_end.jsp").forward(req, resp);
            }
        } else {
            getServletContext().getRequestDispatcher("/start.jsp").forward(req, resp);
        }
    }
}
