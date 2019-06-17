package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;


@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        Connection con = DButils.createConnection();

        try {
            Statement st = con.createStatement();
            String sql = "INSERT INTO users(User, Password, Role) " +
                    "VALUES ('" + username + "','" + password + "','" + role + "')";
            System.out.println(sql);
            st.executeUpdate(sql);
        }
        catch (SQLException sqe) {
            System.out.println("Error : While Inserting record in database");
        }


        try {
            con.close();
        } catch (SQLException se) {
            System.out.println("Error : While Closing Connection");
        }

        //response.sendRedirect("");
        request.setAttribute("username", username);

        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }
}

