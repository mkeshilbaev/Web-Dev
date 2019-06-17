<%--
  Created by IntelliJ IDEA.
  User: mkesh
  Date: 21.05.2019
  Time: 0:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>


<body>
<div class="header">
    <h2>Login</h2>
</div>
<form action="LoginServlet" method="post">
    <div class="input-group">
        <label>Username</label>
        <input type="text" name="username" required="required">
    </div>
    <div class="input-group">
        <label>Password</label>
        <input type="password" name="password" required="required">
    </div>
    <div class="input-group">
        <label>Role (1 for content creator || 2 for reader)</label>
        <input type="text" name="role" required="required">
    </div>
    <div class="input-group">
        <button type="submit" class="btn">Login</button>
    </div> <br>
</form>

</body>

</html>
