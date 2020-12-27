<%@ page import="com.atguigu.servlet.ImgUtils" %><%--
  Created by IntelliJ IDEA.
  User: TingHL
  Date: 2020-12-17
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
      <div class="imgs"><img src="/FileUploadAndDownloadDemo2_war_exploded/${path}"/></div>
    </c:forEach>
  </div>

  <!-- 服务器中的文件的流交给浏览器-->
  <!--下载浏览器中的已经存在的文件-->
  <h1>下载浏览器中已经存在的文件</h1><br>
  <a href="download?file=zip">下载zip</a>
  <a href="download?file=jpg">下载图片</a>

  </body>
</html>
