package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Connection con = DButils.createConnection();
        ResultSet set = null;
        PrintWriter out = response.getWriter();
        int i = 0;

          try {
            Statement st = con.createStatement();
            String sql = "Select * from  users where username='" + username + "' and password='" + password + "' ";
            System.out.println(sql);
            set = st.executeQuery(sql);

            while (set.next()) {
                i = 1;
            }
            if (i != 0) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                //response.sendRedirect();
                RequestDispatcher rd = request.getRequestDispatcher("/ProfileServlet");
                rd.forward(request, response);

            } else {
                out.println("Wrong username or password");
                request.setAttribute("errorMessage", "Invalid username or password");
                //response.sendRedirect("login.jsp");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }
        } catch (SQLException sqe) {
            System.out.println("Error : While Fetching records for login from database");
        }


        try {
            con.close();
        } catch (SQLException se) {
            System.out.println("Error : While Closing login Connection");
        }
    }
}



