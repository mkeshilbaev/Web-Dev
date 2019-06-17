package servlets;

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


@WebServlet(name = "ProfileServlet")
public class ProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        Connection con = DButils.createConnection();
        ResultSet rs;
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        try {
            Statement st = con.createStatement();
            String sql = "Select * from  users WHERE username = '" + username + "'";
            System.out.println(sql);
            rs = st.executeQuery(sql);
            String str = "";

            while (rs.next()) {
                String username1 = rs.getString("username");
                String email = rs.getString("email");
                String age = rs.getString("age");
                String address = rs.getString("address");
                String hometown = rs.getString("hometown");

                str +=  "<h1>HOME PAGE</h1>"+
                        "<hr />"+
                        "<table>" +
                          "<tr><td>avatar:</td><td><img src=/></td></tr>" +
                          "<tr><td>username:</td><td>"+username1+"</td></tr>" +
                          "<tr><td>email:</td><td>"+email+"</td></tr>" +
                          "<tr><td>age:</td><td>"+age+"</td></tr>" +
                          "<tr><td>address:</td><td>"+address+"</td></tr>" +
                          "<tr><td>hometown:</td><td>"+hometown+"</td></tr>" +
                        "</table>" +
                        "<hr />" +
                 "<a href=\"http://localhost:8080/logout.jsp\">Logout</a>";
            }
            pw.println(str);

        } catch (SQLException sqe) {
            System.out.println("Error : While Fetching records for profile from database");
        }


        try {
            con.close();
        } catch (SQLException se) {
            System.out.println("Error : While Closing Connection");
        }

        finally {
            pw.close();
        }
    }
}
