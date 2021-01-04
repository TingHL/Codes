<%--
  Created by IntelliJ IDEA.
  User: TingHL
  Date: 2021-01-01
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>TingHL</title>
  </head>
  <body>
  <a href="book/1">查询图书</a>

  <form action="book/1" method="post">
    <input type="submit" value="添加1号图书">
  </form>

  <form action="book/1" method="post">
    <input name="_method" value="delete">
    <input type="submit" value="删除1号图书">
  </form>

  <form action="book/1" method="post">
    <input name="_method" value="put">
    <input type="submit" value="更新1号图书">
  </form>

  </body>
</html>
