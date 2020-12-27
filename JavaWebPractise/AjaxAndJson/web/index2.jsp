<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: TingHL
  Date: 2020-12-27
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TingHL</title>
    <script type="text/javascript" src="WebApp/jquery-1.7.2.min.js"></script>
    <%
        pageContext.setAttribute("ctp",request.getContextPath());
    %>
    <style type="text/css">
        div{
            border: 1px solid #BBB;
            float:left;
            margin-left: 20px;
            width: 200px;
            height: 180px;
        }
    </style>
</head>

<body>
<div>
    div1:<%=new Date()%>
</div>
<div>
    div2:<%=new Date()%>
</div>
<div>
    div3:<%=new Date()%><br/>
</div>
<br/>
<hr/>
<a id="aBtn" href="getstuinfo">获取学生数据</a><br/>
    <a id="aBtnAjax" href="getstuinfo">获取学生数据-使用底层的Ajax</a><br/>
</body>

<script type="text/javascript">
    //url：请求地址
    //一下参数可选
    //data：请求发送的数据，可以写k=v&k=v 也可以写js对象（自动转）
    //callback：回调函数，响应成功以后的回调函数
    //type：指定返回的数据类型，jquery可以自动转为指定的类型
    // $.get("${ctp}/getstuinfo")
    //js中可以使用“el表达式”来取出el表达式中的值
    $("#aBtn").click(function () {
        $.get("${ctp}/getstuinfo");
        return false;
    });

    $("#aBtnAjax").click(function (){
        //发送ajax请求
        var options={
            url:"${ctp}/getstuinfo",//规定请求地址
            type:"GET",//请求方式
            data:{"lastName":"haha",age:22},//发送的数据
            async:false,//调整异步（true）/同步（false）
            success:function(data){
                //alert("成功!"+(typeof data));
                //把收到的数据放在第三个div中
                var lastName=data.lastName;
                var age=data.age;
                $("div:eq(2)").append("姓名"+lastName+"<br/>年龄:"+age);
                $("div:eq(2)").css("background-color","#bbb");
            },
            error:function (a,b){
              alert("请求失败,"+b+"状态码："+a.status);
            },
            dataType:"json"
        };
        $.ajax(options);

        //默认Ajax是异步的，数据的接受与下面的方法执行不冲突
        //异步：不用等待整个Ajax请求完成才执行下面的方法
        //同步：等待ajax整个完成，才会执行后面的方法
        alert("哈哈");
        return false;
    });
</script>
</html>
