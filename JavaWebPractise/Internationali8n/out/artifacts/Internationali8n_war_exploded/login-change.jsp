<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: TingHL
  Date: 2020-12-17
  Time: 12:17
  To change this template use File | Settings | File Templates.
  点击超链接 国际化
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>TingHL</title>
</head>
<body>

<%--使用FMT标签库实现动态获取信息 完成以前的功能--%>
<%--
1.准备一个能够的区域信息
2.使用ResourceBundle绑定国际化资源文件
3.从国际化资源文件中获取值 可以继续格式化
        其中，两者有重要的区别
            ${requestScope.loc}==request.getAttribute("loc","")
            ${param.loc}== request.getParameter("loc")
--%>
<fmt:setLocale value="${param.loc}"/> <!-- 相当于 Locale locale=new Locale(param.loc}-->
<fmt:setBundle basename="bookstore"></fmt:setBundle>
<h1>
    <fmt:message key="welcome">
        <fmt:param>李</fmt:param>
        <fmt:param>
            <fmt:formatDate value="<%=new Date()%>"></fmt:formatDate>
        </fmt:param>
    </fmt:message>
</h1>
<form action="">
    <fmt:message key="username" />:<input /><br/>
    <fmt:message key="password"/>:<input /><br/>
    <input type="submit" value="<fmt:message key="loginBtn"/>"/>
</form>
<a href="login-change.jsp?loc=zh_CN">中文</a>
<a href="login-change.jsp?loc=en_US">English</a>
</body>
</html>
