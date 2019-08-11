
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加数据</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="../../js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="../../js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function a(){
            var form={};
            var name = $("#name").val();
            var pwd = $("#pwd").val();
            form["name"]=name;
            form["pwd"]=pwd;

            console.log(JSON.stringify(form));
            $.ajax({
                enctype: "multipart/form-data",
                type:'POST',
                contentType: "application/json; charset=utf-8",
                dataType:'json',
                url:"http://localhost:8080/weixiu/register",
                data:JSON.stringify(form),
                success:function(result){
                 alert("注册成功，你可以重新登录！");
                    window.location.href="http://localhost:8080";
                }
            });
        }
    </script>
</head>
<body>
<div style="margin:50px 300px ;border: #a71d2a solid 2px;width: 500px;height: 700px;padding: 50px;background-color: #8fd19e">
<h2>注册页面</h2>
<div>
        <div class="form-group">
            <label >用户名:</label>
            <input type="text" class="form-control" id="name" placeholder="用户名">
        </div>
        <div class="form-group">
            <p>密码: </p>
            <textarea style="width: 400px" id="houguo" placeholder="后果">
            </textarea>
        </div>
        <br>
        <button type="submit"  onclick="javascript:a()" class="btn btn-primary">注册</button>
    <%--</form>--%>
</div>
</div>
</body>
</html>
