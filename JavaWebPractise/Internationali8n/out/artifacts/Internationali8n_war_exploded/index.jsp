<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %><%--
  Created by IntelliJ IDEA.
  User: TingHL
  Date: 2020-12-16
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>TingHL</title>
  </head>
  <body>
  <%-- 根据不同区域信息 将这个而页面动态显示--%>
  <%--
  步骤1：获取当前浏览器带来的区域信息 针对“Accept-Language: zh-CN,zh;q=0.9,en;q=0.8”
  步骤2：使用ResourceBundle管理国际化资源文件
  步骤3：动态获取配置文件中的值
   --%>
  <%
    String locale=request.getHeader("Accept-Language").split(",")[0];
    String[] loc = locale.split("-");
    Locale newLoc = new Locale(loc[0], loc[1]);
    ResourceBundle bundle = ResourceBundle.getBundle("bookstore", newLoc);
    String username = bundle.getString("username");
    String password = bundle.getString("password");
    String loginBtn = bundle.getString("loginBtn");
  %>
  <form action="">
    <%=username%>:<input /><br/>
    <%=password%>:<input /><br/>
    <input type="submit" value="<%=loginBtn%>"/>
  </form>
  <a href="login-change.jsp?param=zh_CN">中文</a>
  </body>
</html>

