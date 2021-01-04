<%--
  Created by IntelliJ IDEA.
  User: TingHL
  Date: 2021-01-03
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%
    pageContext.setAttribute("ctp",request.getContextPath());
%>
<head>
    <title>员工列表页面</title>
    <script type="text/javascript" src="${ctp}/scripts/jquery-3.5.0.min.js"></script>
</head>
<body>
<h1>员工列表</h1>

<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>lastName</th>
        <th>email</th>
        <th>gender</th>
        <th>departmentName</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${emps}" var="emp">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.lastName}</td>
            <td>${emp.email}</td>
            <td>${emp.gender==0?"女":"男"}</td>
            <td>${emp.department.departmentName}</td>
            <td><a href="${ctp}/emp/${emp.id}">Edit</a></td>
            <td><a href="${ctp}/emp/${emp.id}" class="delBtn">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<a href="toaddpage">添加员工</a><br>

<form action="${ctp}/quickadd" method="post">
    <input name="empinfo" value="empAdmin-admin@qq.com-1-101"/>
    <input type="submit" value="快速添加"/>
</form>

<form id="deleteForm" action="${ctp}/emp/${emp.id}" method="post">
    <input type="hidden" name="_method" value="DELETE">
</form>
<script type="text/javascript">
    $(function (){
        $(".delBtn").click(function (){
            //1.改变action的表单指向
            $("#deleteForm").attr("action",this.href);
            //2.提交表单之前进行confirm确认
            if(confirm("Click OK to continue")){
                $("#deleteForm").submit();
            }
            //3.禁用原方法
            return false;
        });
    });
</script>

</body>
</html>
