<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="servlets.DButils" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: mkesh
  Date: 21.05.2019
  Time: 0:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Profile System</title>
    <script type="text/javascript" src="script.js"></script>
</head>
<body>
    <h1>HOME PAGE</h1>
    <p>you are logged in as an Event creator.</p>
    <a href="http://localhost:8080/createEvent.jsp">Create 1 event</a>      |      <a href="http://localhost:8080/createEvent.jsp">Create 2 events</a>     |      <a href="http://localhost:8080/createEvent.jsp">Create 3 events</a>      |      <a href="http://localhost:8080/logout.jsp">Logout</a>
</body>
</html>
