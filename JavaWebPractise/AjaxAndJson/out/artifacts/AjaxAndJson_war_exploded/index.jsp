<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: TingHL
  Date: 2020-12-27
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>TingHL</title>
    <!-- 引入jquery -->
    <script type="text/javascript" src="WebApp/jquery-1.7.2.min.js"></script>
  </head>
  <body>
  <script type="text/javascript">
    var student;
    student = {
      lastName: "张三",
      age: 18,
      car: {pp: "宝马", price: "$3000"},
      infos: [{bookName: "西游记", price: 98.98}, 18, true]
    };
    //js对象，属性操作特别方便
    //alert(student.car.pp);
    //alert(student.infos[2]);

    //json的要求和js对象是一样的，只不过key必须是字符串
    //js对象在声明的时候key是否加双引号是可以选择的
    var student2={
      "lastName":"张三",
      "age":18
    };
    //alert(student2);

    //JSON(js内置的对象）：将js对象转换为json字符串（js对象的字符串表示法）
    var strJson=JSON.stringify(student2);
    //alert(strJson);
  </script>
  <%=new Date()%>
  <a href="getinfo">获取信息</a>
  <div>
    显示信息：
  </div>
  </body>
<script type="text/javascript">

</script>
</html>
