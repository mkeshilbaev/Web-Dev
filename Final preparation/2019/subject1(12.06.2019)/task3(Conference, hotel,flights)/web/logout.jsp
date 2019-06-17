<%--
  Created by IntelliJ IDEA.
  User: mkesh
  Date: 21.05.2019
  Time: 0:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logout</title>
</head>
<body>

<%
    session.setAttribute("username", null);
    session.invalidate();
    response.sendRedirect("login.jsp");
 %>

</body>
</html>
