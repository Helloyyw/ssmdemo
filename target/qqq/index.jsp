<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>在线通讯录</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="../../js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="../../js/bootstrap.min.js"></script>
</head>
<script type="text/javascript">
    function check(){
        var name = $("#name").val();
        var pwd = $("#pwd").val();
        if (name == "" || pwd == "" || name==null || pwd==null) {
            alert("输入的用户名或密码不能为空")
            return false;
        }
        var form={};
        alert(name + pwd);
        form["name"]=name;
        form["pwd"]=pwd;
        console.log(JSON.stringify(form));
        $.ajax({
            enctype: "multipart/form-data",
            type:'POST',
            contentType: "application/json; charset=utf-8",
            dataType:'json',
            url:"http://localhost:8080/weixiu/login",
            data:JSON.stringify(form),
            success:function(result){
                alert(result.msg);
                var  name = result.data.name;
                console.log(name);
                // window.history.back(-1);
                 window.location.href="http://localhost:8080/weixiu/tellist";
            }
        });

    }
</script>
</head>
<body>
<!-- 表单设计 -->
<center>
<div style="margin-top:100px;width: 500px;height: 400px;color: #66afe9;border: 2px solid #000000 " >
    <div style="margin-top: 50px">
   <div style="padding: 10px">
       <h2>在线通讯录系统</h2>
       <br>
       <label>用户名：</label>
       <input type="text" id="name" placeholder="请输入用户名">
   </div>
    <br>
    <div style="padding: 10px">
        <label>密码：</label>
        <input type="text" id="pwd" placeholder="请输入密码">
    </div>
    <div style="padding: 10px">
        <input type="button" class="btn-primary" id="login" onclick="check()" value="登录">
        <a  class="btn-primary"  href="<%=request.getContextPath()%>/views/register.jsp">注册</a>
    </div>
    </div>
</div>
</center>
</body>
</html>
