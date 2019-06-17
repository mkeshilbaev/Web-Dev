<%@ page import="java.sql.Connection" %>
<%@ page import="servlets.DButils" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: mkesh
  Date: 13.06.2019
  Time: 23:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Conference</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
</head>

<body>
<div id="div1">
    <script>
        $.get("FlightServlet", function (html) {
            $("#div1").html(html);
        });
    </script>
</div>

</body>
</html>
