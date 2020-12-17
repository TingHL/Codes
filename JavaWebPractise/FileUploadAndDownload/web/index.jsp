<%--
  Created by IntelliJ IDEA.
  User: TingHL
  Date: 2020-12-17
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>欢迎光临尚硅谷网上图库</title>
  </head>
  <body>
  <form action="upload" method="post" enctype="multipart/form-data">
    用户名：<input type="text" name="username"/><br>
    头像：<input type="file" name="headerimg"/><br>
    <input type="submit" value="上传"/>
  </form>
  </body>
</html>
