package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "ConferenceServlet")
public class ConferenceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = DButils.createConnection();
        ResultSet rs = null;
        PrintWriter out = response.getWriter();
        String str = "";

        try {
            Statement st = con.createStatement();
            String sql = "Select * from  conferences";
            System.out.println(sql);
            rs = st.executeQuery(sql);
            str = "<h1>Register for the conference</h1>"+
                    "<table>" +
                    "                        <tr> " +
                    "                        <th>ID</th> " +
                    "                        <th>Name</th> " +
                    "                        <th>City</th>" +
                    "                        <th>Date</th> " +
                    "                        <th>Slots</th> " +
                    "                        </tr> ";

            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String city = rs.getString("city");
                String date = rs.getString("date");
                String slots = rs.getString("slots");

                str += "<tr>" +
                        "<td>"+id+"</td>" +
                        "<td>"+name+"</td>" +
                        "<td>"+city+"</td>" +
                        "<td>"+date+"</td>" +
                        "<td>"+slots+"</td>" +
                        "<td>" +
                        "<form action='ReserveConferenceServlet' method='post'><input type='hidden' name='id' value='"+ id +"' /><button type='submit' id='btnFlight'>Reserve</button></form></td>" +
                        "</tr>";
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
