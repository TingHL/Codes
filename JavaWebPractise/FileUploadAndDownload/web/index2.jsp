<%--
  Created by IntelliJ IDEA.
  User: TingHL
  Date: 2020-12-17
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TingHL</title>
</head>
<body>
<form action="upload2" enctype="multipart/form-data" method="post">
    用户名：<input type="text" name="username"/><br>
    昵称：<input type="text" name="nickname"/><br>
    头像：<input type="file" name="headerimg"/><br>
    <input type="submit" value="上传"/>
</form>
</body>
</html>
