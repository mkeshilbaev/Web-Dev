package servlets;

import javax.jms.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.PrintWriter;

@WebServlet(name = "ReserveFlightServlet")
public class ReserveFlightServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        Connection con = DButils.createConnection();
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getSession(false).getAttribute("username").toString();

        try {
            Statement st = con.createStatement();
            String sql = "INSERT INTO flightreservations(idFlight, client) " +
                    "VALUES ('" + id + "','" + username + "')";
            System.out.println(sql);
            st.executeUpdate(sql);
            pw.println("Flight successfully reserved!");
            System.out.println("Flight successfully reserved!");
        }
        catch (SQLException sqe) {
            System.out.println("Error : While Inserting record in database");
        }

        try {
            Statement st = con.createStatement();
            String sql = "UPDATE flights " +
                    "SET seats = seats - 1 WHERE  id ='" + id + "'";
            System.out.println(sql);
            st.executeUpdate(sql);
            pw.println("Flight seats were successfully updated!");
        }
        catch (SQLException sqe) {
            System.out.println("Error : While Inserting record in database");
        }

        try {
            con.close();
        } catch (SQLException se) {
            System.out.println("Error : While Closing Connection");
        }
        response.sendRedirect("HotelServlet");
       // RequestDispatcher rd = request.getRequestDispatcher("HotelServlet");
        //rd.forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
