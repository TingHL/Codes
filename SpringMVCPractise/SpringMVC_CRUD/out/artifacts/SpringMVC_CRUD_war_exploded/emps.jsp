<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: TingHL
  Date: 2021-01-05
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("ctp",request.getContextPath());
%>
<script type="text/javascript" src="${ctp}/scripts/jquery-3.5.0.min.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%=new Date()%>
<a href="${ctp}/getallajax">ajax获取所有员工</a><br/>
<div>

</div>
<script type="text/javascript">
    $("a:first").click(function(){
       //1.发送ajax获取所有员工
        $.ajax({
            url:"${ctp}/getallajax",
            type:"GET",
            success:function (data){
                //console.log(data);
                $.each(data,function(){
                    var empInfo=this.lastName+"-->"+this.birth+"-->"+this.gender;
                    $("div").append(empInfo+"<br/>");
                })
            }
        });
        return false;
    });
</script>

</body>
</html>
