<%--
  Created by IntelliJ IDEA.
  User: TingHL
  Date: 2021-01-03
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Edit Pages</title>
</head>
<body>
<%
    pageContext.setAttribute("ctp",request.getContextPath());
%>
<h1>员工修改页面</h1>
<!-- 指定表单中所有内容显示绑定的是请求域中employee的值-->
<form:form action="${ctp}/emp/${employee.id}"  modelAttribute="employee" method="post" >
    <input type="hidden" name="_method" value="put"/>
    <input type="hidden" name="id" value="${employee.id}"/>
    email:<form:input path="email"/><br/>
    gender:&nbsp;&nbsp;&nbsp;
        男:<form:radiobutton path="gender" value="1"/>&nbsp;&nbsp;&nbsp;
        女:<form:radiobutton path="gender" value="0"/><br/>
    dept:<form:select path="department.id" items="${depts}" itemLabel="departmentName" itemValue="id"/><br/>
    <input type="submit" value="修改"/>
</form:form>
</body>
</html>
