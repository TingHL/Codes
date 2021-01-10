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
    <%--1.文件上传
    1.文件上传表单准备
    2.导入fileupload包 commons-fileupload-1.4.jar commons-io-2.8.0.jar
    3.在SpringMVC配置文件中，编写配置，配置文件上传解析器 MultipartyResolver
    4.文件上传请求处理 在处理器方法上写一个@RequestParam("headerimg") MultipartFile file
      --%>
  <form action="${ctp}/upload" method="post" enctype="multipart/form-data">
      用户头像：<input type="file" name="headerimg"/><br/>
      用户名：<input type="text" name="username"/><br/>
      <input type="submit"/>
  </form>

    <form action="${ctp}/uploadFiles" method="post" enctype="multipart/form-data">
        用户头像：<input type="file" name="headerimg"/><br/>
        用户头像：<input type="file" name="headerimg"/><br/>
        用户头像：<input type="file" name="headerimg"/><br/>
        用户头像：<input type="file" name="headerimg"/><br/>
        用户名：<input type="text" name="username"/><br/>
        <input type="submit"/>
    </form>

  </body>
</html>
