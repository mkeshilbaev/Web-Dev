package servlets;

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

@WebServlet(name = "FlightServlet")
public class FlightServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = DButils.createConnection();
        ResultSet rs = null;
        PrintWriter out = response.getWriter();
        String str = "";


        try {
            Statement st = con.createStatement();
            String sql = "Select * from  flights";
            System.out.println(sql);
            rs = st.executeQuery(sql);
            str = "<h1>Reserve a flight</h1>" +
                    "<table>" +
                    "                        <tr> " +
                    "                        <th>ID</th> " +
                    "                        <th>Name</th> " +
                    "                        <th>departure</th>" +
                    "                        <th>destination</th> " +
                    "                        <th>date</th> " +
                    "                        <th>seats</th> " +
                    "                         <th>reserve</th> " +
                    "                        </tr> ";

            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String departure = rs.getString("departure");
                String destination = rs.getString("destination");
                String date = rs.getString("date");
                String seats = rs.getString("seats");

                str += "<tr>" +
                        "<td>" + id + "</td>" +
                        "<td>" + name + "</td>" +
                        "<td>" + departure + "</td>" +
                        "<td>" + destination + "</td>" +
                        "<td>" + date + "</td>" +
                        "<td>" + seats + "</td>" +
                        "<td>";
                if (Integer.parseInt(seats) > 0){
                    str += "<form action='ReserveFlightServlet' method='post'><input type='hidden' name='id' value='" + id + "' /><button type='submit' id='btnFlight'>Reserve</button></form></td></tr>";
                }

            }
            str += "</table>" +
                    "<hr />" +
                    "<a href=\"http://localhost:8080/logout.jsp\">Logout</a>";
            out.println(str);

        } catch (SQLException sqe) {
            System.out.println("Error : While Fetching records from flights table");
        }

        try {
            con.close();
        } catch (SQLException se) {
            System.out.println("Error : While Closing login Connection");
        }
    }


}
