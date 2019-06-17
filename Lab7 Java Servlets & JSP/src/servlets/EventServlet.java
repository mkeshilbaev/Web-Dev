package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

@WebServlet(name = "EventServlet")
public class EventServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String date = request.getParameter("date");
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        Connection con = DButils.createConnection();

        try {
            //LocalDate date1 = LocalDate.now();
            int id = (int)request.getAttribute("userid");
            Statement st = con.createStatement();
            String sql = "INSERT INTO events(Date, Title, Description, UserID) " +
                    "VALUES ('" +  date + "','" + title + "','" + description + "', '" + id + "')";
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
    }
}
