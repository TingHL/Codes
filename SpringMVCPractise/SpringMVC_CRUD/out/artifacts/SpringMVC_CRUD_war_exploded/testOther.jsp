<%--
  Created by IntelliJ IDEA.
  User: TingHL
  Date: 2021-01-05
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <% pageContext.setAttribute("ctp",request.getContextPath());%>
</head>
<script type="text/javascript" src="scripts/jquery-3.5.0.min.js"></script>
<body>
<form action="${ctp}/test02" method="post" enctype="multipart/form-data">
    <input name="username" value="tomcat"/>
    <input name="password" value="123456"/>
    <input name="file" type="file"/>
    <input type="submit" value="提交">
</form>
<a href="${ctp}/testRequestBody">ajax发送json数据</a>
</body>
</html>
