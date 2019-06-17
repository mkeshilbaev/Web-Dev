<%--
  Created by IntelliJ IDEA.
  User: mkesh
  Date: 21.05.2019
  Time: 0:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
<div class="header">
    <h2>Register</h2>
</div>

<form action="RegisterServlet" method="post">
    <div class="input-group">
        <label>Username</label>
        <input type="text" name="username" required="required">
    </div>
    <div class="input-group">
        <label>Password</label>
        <input type="Password" name="password" required="required">
    </div>
    <div class="input-group">
        <label>Email</label>
        <input type="text" name="email" required="required">
    </div>
    <div class="input-group">
        <label>Age</label>
        <input type="text" name="age" required="required">
    </div>
    <div class="input-group">
        <label>Address</label>
        <input type="text" name="address" required="required">
    </div>
    <div class="input-group">
        <label>Hometown</label>
        <input type="text" name="hometown" required="required">
    </div>
    <div class="input-group">
        <button type="submit" class="btn">Register</button>
    </div> <br>
    <p>
        Already registered? <a href="http://localhost:8080/login.jsp">Sign in</a>
    </p>
</form>

</body>

</html>
