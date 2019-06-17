package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.RequestDispatcher;

//@WebServlet(urlPatterns = { "/login", "/register", "/takeExam", "/logout" })
@WebServlet(name = "MainControllerServlet")
public class MainControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
/*
        String applicationContextPath = request.getContextPath();

        if (request.getRequestURI().equals(applicationContextPath + "/")) {
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/web/home.jsp");
            dispatcher.forward(request, response);
        } else if (request.getRequestURI().equals(
                applicationContextPath + "/login")) {
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/web/login.jsp");
            dispatcher.forward(request, response);
        } else if (request.getRequestURI().equals(
                applicationContextPath + "/register")) {
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/web/register.jsp");
            dispatcher.forward(request, response);
        }


        if (request.getRequestURI().equals(
                applicationContextPath + "/logout")) {
            request.getSession().invalidate();
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/web/home.jsp");
            dispatcher.forward(request, response);
        }*/
    }


}
