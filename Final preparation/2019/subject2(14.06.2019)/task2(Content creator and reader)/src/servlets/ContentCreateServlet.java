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
import java.util.Date;

@WebServlet(name = "ContentCreateServlet")
public class ContentCreateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String url = request.getParameter("url");
        String user = request.getSession(false).getAttribute("userid").toString();
        Date date = new Date();

        Connection con = DButils.createConnection();

        try {
            Statement st = con.createStatement();
            String sql = "INSERT INTO content(contentdate, title, description, url, userid) " +
                    "VALUES ('" + date.toString() + "','" + title + "','" + description + "' ,'" + url + "','" + user + "')";
            System.out.println(sql);
            st.executeUpdate(sql);
        }
        catch (SQLException sqe) {
            System.out.println("Error : While inserting record into 'content' table");
        }
        try {
            con.close();
        } catch (SQLException se) {
            System.out.println("Error : While Closing Connection");
        }

        //response.sendRedirect("");
        //RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        //dispatcher.forward(request, response);
    }

}
