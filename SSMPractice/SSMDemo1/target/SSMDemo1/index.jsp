<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<h2>SSM测试小例子</h2>
<div id="d1" style="border: dashed;height: 100px;width: 300px">
    传入文本：<input type="text" id="send_text">
    <button id="btn1">发送</button>
</div>
<div id="d2" style="border: dashed;height: 100px;width: 300px">
    收到文本：<input type="text" id="receive_text">
</div>
<script>
    $("#btn1").click(function () {
        $.ajax({
            url: "testssm", //后台url
            type: "post",
            data: {"sendmessage": $("#send_text").val()},
            success: function (data) {
                $("#receive_text").val(data)
            }
        })
    });
</script>
</body>
</html>
