<%@ page import="com.atguigu.servlet.ImgUtils" %><%--
  Created by IntelliJ IDEA.
  User: TingHL
  Date: 2020-12-17
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=GB2312" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html;charset=GB2312"/>
<html>
<head>
    <title>��ӭ���ٹ������ͼ��</title>
    <%--  �涨ͼƬ����ʽ ��ǰ���� --%>
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

<h1>ѡ���ϴ��ļ� �����ϴ�����ļ��ڴ��ṩ��������</h1><br>
<!--�ϴ� �������Դ�ϴ��� ͨ��uploadpic Servlet���д��� �����ϴ�����ͼƬȫ����ʾ��ҳ������ -->
<form method="post" enctype="multipart/form-data" action="uploadpic">
    �û�����<input type="text" name="username"/>
    ͼƬ��<input type="file" name="pic"/>
    <input type="submit" value="�ϴ�"/>
</form>
<hr/>


<div>
    <%-- �������е�ͼƬ   --%>
    <%-- items��Ҫ��ѭ������Ϣ var������ǰ��Ŀ�ı�������   --%>
    <c:forEach items="<%=ImgUtils.getAllPaths()%>" var="path">
        <div class="imgs">
            <img src="/FileUploadAndDownloadDemo2_war_exploded/${path}"/>
            <a href="downloadTwo?file=${path}">����ͼƬ</a>
        </div>
    </c:forEach>
</div>


</body>
</html>
