<%--
  Created by IntelliJ IDEA.
  User: mkesh
  Date: 13.06.2019
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Events web site</title>
</head>

<body>
<div class="header">
    <h2>Create an event</h2>
</div>

<form action="RegisterServlet" method="post">
    <div class="input-group">
        <label>Date</label>
        <input type="text" name="date" required="required">
    </div>
    <div class="input-group">
        <label>Title</label>
        <input type="text" name="title" required="required">
    </div>
    <div class="input-group">
        <label>Description</label>
        <input type="text" name="description" required="required">
    </div>
    <div class="input-group">
        <button type="submit" class="btn">Create</button>
    </div> <br>
    <p>
        Do you want to delete your event? <a href="http://localhost:8080/login.jsp">Go</a>
    </p>
</form>


</body>
</html>
