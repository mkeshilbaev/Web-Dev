<%--
  Created by IntelliJ IDEA.
  User: mkesh
  Date: 14.06.2019
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Content</title>
</head>

<body>

<div class="header">
    <p>You login as content creator</p>
    <hr>
    <h2>Create content</h2>
</div>
<form action="ContentCreateServlet" method="post">
    <div class="input-group">
        <label>Title</label>
        <input type="text" name="title" required="required">
    </div>
    <div class="input-group">
        <label>Description</label>
        <input type="text" name="description" required="required">
    </div>
    <div class="input-group">
        <label>URL</label>
        <input type="text" name="url" required="required">
    </div>
    <div class="input-group">
        <button type="submit" class="btn">Create</button>
    </div> <br>
</form>

</body>
</html>
