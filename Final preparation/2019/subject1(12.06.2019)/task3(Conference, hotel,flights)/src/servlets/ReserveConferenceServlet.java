package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "ReserveConferenceServlet")
public class ReserveConferenceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = DButils.createConnection();
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getSession(false).getAttribute("username").toString();

        try {
            Statement st = con.createStatement();
            String sql = "INSERT INTO conferenceregistrations(idConference, client) " +
                    "VALUES ('" + id + "','" + username + "')";
            System.out.println(sql);
            st.executeUpdate(sql);
            System.out.println("Conference successfully reserved!");
        }
        catch (SQLException sqe) {
            System.out.println("Error : While Inserting record in database");
        }

        try {
            Statement st = con.createStatement();
            String sql = "UPDATE conferences " +
                    "SET slots = slots - 1 WHERE  id ='" + id + "'";
            System.out.println(sql);
            st.executeUpdate(sql);
            System.out.println("Conference slots were successfully updated!");
        } catch (SQLException sqe) {
            System.out.println("Error : While Inserting record in database");
        }

        try {
            con.close();
        } catch (SQLException se) {
            System.out.println("Error : While Closing Connection");
        }
        response.sendRedirect("home.jsp");
        //RequestDispatcher rd = request.getRequestDispatcher("");
        //rd.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
