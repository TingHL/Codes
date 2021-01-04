<%--
  Created by IntelliJ IDEA.
  User: TingHL
  Date: 2021-01-03
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<fmt:message key="welcomeinfo"></fmt:message>
<form action="">
    <fmt:message key="username"></fmt:message>:<input/><br/>
    <fmt:message key="password"></fmt:message>:<input/><br/>
    <input type="submit" value='<fmt:message key="loginBtn"></fmt:message>'/><br/>
</form>
</body>
</html>
