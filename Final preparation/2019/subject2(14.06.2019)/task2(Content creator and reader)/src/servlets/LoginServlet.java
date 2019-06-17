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
        String role = request.getParameter("role");

        Connection con = DButils.createConnection();
        ResultSet rs;
        PrintWriter out = response.getWriter();
        int i = 0;

        try {
            Statement st = con.createStatement();
            String sql = "Select * from users where user ='" + username + "' and password ='" + password + "' and role ='" + role + "'";
            System.out.println(sql);
            rs = st.executeQuery(sql);

            while (rs.next()) {
                i = 1;
            }
            if (i != 0) {
                //String role = rs.getString("role");
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("role", role);
                String userid = rs.getString("id");
                session.setAttribute("userid", userid);
            }
            else {
                out.println("Wrong username or password");
                request.setAttribute("errorMessage", "Invalid username or password");

                //response.sendRedirect("login.jsp");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }
        }
        catch (SQLException sqe) {
            System.out.println("Error : While Fetching records for login from database");
        }
        try {
            con.close();
        } catch (SQLException se) {
            System.out.println("Error : While Closing login Connection");
        }

        if(role.equals("1")){
            response.sendRedirect("contentCreate.jsp");
            //RequestDispatcher rd = request.getRequestDispatcher("/CreateContentServlet");
            //rd.forward(request, response);
        }
        if(role.equals("2")){
            //response.sendRedirect();
            RequestDispatcher rd = request.getRequestDispatcher("");
            rd.forward(request, response);
        }

    }
}



