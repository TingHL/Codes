<%--
  Created by IntelliJ IDEA.
  User: TingHL
  Date: 2021-01-03
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>员工添加</title>
</head>
<body>
<h1>员工添加</h1><br/>

<h1>表单标签</h1><br/>
<%--表单标签 通过SpringMVC的表单标签可以实现模型数据中的属性和HTML表单元素相绑定，以实现表单数据更便捷编辑和表单值的回显
    1.SpringMVC认为表单数据中的每一项最终都是要回显的
        path指定的是一个属性，这个属性是从隐含模型（请求域中取出的某个对象中的属性）
        path指定的每一个属性，请求域中必须有一个对象，拥有这个属性，这个对象是请求域中command中的值
        modelAttribute="";
        以前表单标签会从请求域获取一个command对象，把这个对象中的每个属性对应的显示出来
        可以使用modelAttribute，代替command对象，取对象用的key用modelAttribute指定
    2.
 --%>
<%
    pageContext.setAttribute("ctp",request.getContextPath());
%>

<form:form action="${ctp}/emp" modelAttribute="employee" method="post">
    <!-- path 就是原理HTML-INPUT中的name项 需要写
        path:
            1）当作原生的name项 对应对象的属性
            2）自动回显隐含模型中某个对象对应的这个属性的值

            form:errors 显示错误信息
    -->
    lastName:<form:input path="lastName"/><form:errors path="lastName"></form:errors>-->${errorInfo.lastName}<br/>
    email:<form:input path="email"/><form:errors path="email"></form:errors>-->${errorInfo.email}<br/>
    gender:<br/>
        男：<form:radiobutton path="gender" value="1"/><br/>
        女：<form:radiobutton path="gender" value="0"/><br/>
    birth:<form:input path="birth"/><form:errors path="birth"></form:errors>-->${errorInfo.birth}<br/>
    dept:
        <!--items：指定要遍历的集合,自动遍历，遍历出的每一个元素都是department对象
            itemLabel="属性"：指定遍历出的这个对象的哪个属性是作为option标签体的值
            itemValue="属性名"：指定哪个遍历出的对象的哪个属性是要提交的值
        -->
    <form:select path="department.id" items="${depts}" itemLabel="departmentName" itemValue="id"/><br/>
    <input type="submit" value="提交"/>
</form:form>

<h1> JST方式 </h1><br/>
<form action="">
    lastName:<input type="text" name="lastName"/><br/>
    email:<input type="text" name="email"/><br/>
    gender:<br/>
        男：<input type="radio" name="gender" value="1"/><br/>
        女：<input type="radio" name="gender" value="0"/><br/>
    department:<select name="department.id">
        <c:forEach items="${depts}" var="dept">
            <%-- 标签体中是在页面的提示选项信息，value才是要真正提交的数据          --%>
            <option value="${dept.id}">${dept.departmentName}</option>
        </c:forEach>
    </select>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
