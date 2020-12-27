<%@ page import="com.atguigu.servlet.ImgUtils" %><%--
  Created by IntelliJ IDEA.
  User: TingHL
  Date: 2020-12-17
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html;charset=GB2312"/>
<html>
<head>
  <title>欢迎光临硅谷网上图库</title>
  <%--  规定图片的样式 提前定义 --%>
  <style type="text/css">
    img{
      width: 300px;
      height: 200px;
    }
    .imgs{
      float:left;
      width: 220px;
    }
  </style>
</head>
<body>

<h1>选择上传文件 并将上传后的文件在此提供下载链接</h1><br>
<!--上传 将相关资源上传到 通过uploadpic Servlet进行处理 并将上传到的图片全部显示在页面内中 -->
<form method="post" enctype="multipart/form-data" action="uploadpic">
  用户名：<input type="text" name="username"/>
  图片：<input type="file" name="pic"/>
  <input type="submit" value="上传"/>
</form>
<hr/>


<div>
  <%-- 遍历所有的图片   --%>
  <%-- items：要被循环的信息 var：代表当前条目的变量名称   --%>
  <c:forEach items="<%=ImgUtils.getAllPaths()%>" var="path">
    <div class="imgs">
      <img src="/FileUploadAndDownloadDemo2_war_exploded/${path}"/>
      <a href="download?file=${path}">下载图片</a>
    </div>
  </c:forEach>
</div>


</body>
</html>
