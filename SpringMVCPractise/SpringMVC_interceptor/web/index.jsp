<%--
  Created by IntelliJ IDEA.
  User: TingHL
  Date: 2021-01-06
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <%
      pageContext.setAttribute("ctp",request.getContextPath());
  %>
  <body>
    <a href="${ctp}/testhandler">test01</a>
  </body>
</html>
