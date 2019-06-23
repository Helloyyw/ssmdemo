
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
            var type = $("#type").val();
            var houguo = $("#houguo").val();
            var yuanyin = $("#yuanyin").val();
            var cuoshi = $("#cuoshi").val();
            form["name"]=name;
            form["type"]=type;
            form["houguo"]=houguo;
            form["yuanyin"]=yuanyin;
            form["cuoshi"]=cuoshi;
            console.log(JSON.stringify(form));
            $.ajax({
                enctype: "multipart/form-data",
                type:'POST',
                contentType: "application/json; charset=utf-8",
                dataType:'json',
                url:"http://localhost:8080/weixiu/add1",
                data:JSON.stringify(form),
                success:function(result){
                 alert("添加成功");
                 // window.history.back(-1);
                    window.location.href="http://localhost:8080/weixiu/one";
                }
            });
        }
    </script>
</head>
<body>
<div style="margin:50px 300px ;border: #a71d2a solid 2px;width: 500px;height: 700px;padding: 50px;background-color: #8fd19e">
<h2>添加一条数据</h2>
<div>
    <%--<form id="from1" class="form-horizontal">--%>
        <div class="form-group">
            <label >故障名称:</label>
            <input type="text" class="form-control" id="name" placeholder="故障名称">
        </div>

        <div class="form-group">
            请选择错误的类型:&nbsp;&nbsp;&nbsp;
            <select class="form-group" id="type" >
                <option>维修前差错</option>
                <option>维修中差错</option>
                <option>维修后差错</option>
            </select>
        </div>

        <div class="form-group">
            <p>后果: </p>
            <textarea style="width: 400px" id="houguo" placeholder="后果">
            </textarea>
        </div>

        <div class="form-group">
            <p >原因: </p>
            <textarea style="width: 400px" id="yuanyin" placeholder="原因">
            </textarea>
        </div>
        <div class="form-group">
            <p >防范措施:</p>
            <textarea style="width: 400px" id="cuoshi" placeholder="防范措施">
            </textarea>
        </div>
        <br>
        <button type="submit"  onclick="javascript:a()" class="btn btn-primary">添加</button>
    <%--</form>--%>
</div>
</div>
</body>
</html>
