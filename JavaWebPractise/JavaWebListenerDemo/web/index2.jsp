<%@ page import="com.atguigu.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: TingHL
  Date: 2020-12-14
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TingHL</title>
</head>
<body>
<h1>活化、钝化、绑定、解绑</h1>
<%
    User user=new User();
    session.setAttribute("loginUser",user);
    Thread.sleep(3000);
    session.removeAttribute("loginUser");
%>
</body>
</html>
