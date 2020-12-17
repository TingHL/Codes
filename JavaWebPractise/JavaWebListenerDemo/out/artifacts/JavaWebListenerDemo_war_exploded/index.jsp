<%--
  Created by IntelliJ IDEA.
  User: TingHL
  Date: 2020-12-11
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>TingHL</title>
  </head>
  <body>
    <%-- index.jsp 中超链接调用hahasession网址，SessionServlet会根据param参数进行函数调用 调用相关的方法，对session进行处理--%>
    index.jsp
    <a href="hahasession?param=getSession">getSession</a>
    <a href="hahasession?param=invalidateSession">invalidate Session</a>

  <%--  本部分主要是对实现HttpSessionAttributeListener的MySessionLifeCycleListener进行测试
        通过对一些属性的设置、变更和消除
   --%>
  <%
    session.setAttribute("user","admin");
    Thread.sleep(3000);
    session.setAttribute("user","root");
    Thread.sleep(3000);
    session.removeAttribute("user");
  %>
  </body>
</html>
