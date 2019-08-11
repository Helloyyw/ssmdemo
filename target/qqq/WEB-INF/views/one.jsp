<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>在线通讯录</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="../../js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="../../js/bootstrap.min.js"></script>
    <script type="text/javascript">

         function send(){
             var name  ="";
             var phone  ="";
               if( !($("#name").val() ==null) ||  !($("#name").val() == "") ){
                   name =  $("#name").val();
              }
             if( $("#phone").val() !=null ||  $("#phone").val() != "" ){
                 phone = $("#phone").val();
             }

               alert(name +phone);
             window.location.href="http://localhost:8080/weixiu/findTel?name="+name+"&phone="+phone;
         }

    </script>
</head>
<body >
<div class="container-fluid">
    <div style="margin-top:50px;margin-left: 300px">
    <div class="row-fluid">
        <div class="span12">
            <h3>欢迎！！登录通讯录</h3>
            <br>
           姓名搜索：
            <input type="text" id="name" class="alert-primary" style="border-radius: 6px;border: 1px solid   " placeholder="请输入姓名" >
           电话搜索：
            <input type="text" id="phone" class="alert-primary" style="border-radius: 6px;border: 1px solid   " placeholder="请输入电话">
            <input class="btn btn-primary" onclick="send()" type="button" >搜索</input>
        </div>
    </div>
    </div>
    <br>
    <div><%--<a class="btn btn-primary" href="<%=request.getContextPath()%>/weixiu/add">点我添加数据</a>--%></div>
            <table id="mytable" class="table table-bordered" style="border: 1px  solid red;margin-top: 20px">
                <thead class="title">
                <tr class="alert-primary">
                    <th>
                        编号
                    </th>
                    <th>
                        联系人姓名
                    </th>
                    <th>
                        电话
                    </th>
                    <th>
                        性别
                    </th>
                    <th>
                        备注
                    </th>
                    <th>
                        操作
                    </th>

                </tr>
                </thead>
                <tbody id="yy">
                <c:forEach items="${all}" var="s">
                    <tr class="success">
                        <td>
                          ${s.id}
                        </td>
                        <td>
                                ${s.name}
                        </td>
                        <td>
                                ${s.sex}
                        </td>
                        <td>
                                ${s.phone}
                        </td>
                        <td>
                                ${s.text}
                        </td>
                        <td>
                              <a href="#">修改</a>
                              <a href="#">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
<!--分页控件，将此代码添加到网页上即可-->
<a id="btn0"></a>
<input id="pageSize" type="text" size="1" maxlength="2" value="getDefaultValue()"/><a> 条 </a> <a href="#" id="pageSizeSet">设置</a>&nbsp;
<a id="sjzl"></a>&nbsp;
<a  href="#" id="btn1">首页</a>
<a  href="#" id="btn2">上一页</a>
<a  href="#" id="btn3">下一页</a>
<a  href="#" id="btn4">尾页</a>&nbsp;
<a>转到&nbsp;</a>
<input id="changePage" type="text" size="1" maxlength="4"/>
<a>页&nbsp;</a>
<a  href="#" id="btn5">跳转</a>
</div>

</div>
<script type="text/javascript">
    /**分页js函数,forpage.js,此代码需要链接在html页面底部，同时需要先加载jquery框架**/
    var pageSize = 5;    //每页显示的记录条数
    var curPage=0;        //当前页
    var lastPage;        //最后页
    var direct=0;        //方向
    var len;            //总行数
    var page;            //总页数
    var begin;
    var end;

    $(document).ready(function display(){//1231123132
        len =$("#mytable tr").length - 1;    // 求这个表的总行数，剔除第一行介绍
        page=len % pageSize==0 ? len/pageSize : Math.floor(len/pageSize)+1;//根据记录条数，计算页数
        // alert("page==="+page);
        curPage=1;    // 设置当前为第一页
        displayPage(1);//显示第一页

        document.getElementById("btn0").innerHTML="当前 " + curPage + "/" + page + " 页    每页 ";    // 显示当前多少页
        document.getElementById("sjzl").innerHTML="数据总量 " + len + "";        // 显示数据量
        document.getElementById("pageSize").value = pageSize;
        $("#btn1").click(function firstPage(){    // 首页
            curPage=1;
            direct = 0;
            displayPage();
        });
        $("#btn2").click(function frontPage(){    // 上一页
            direct=-1;
            displayPage();
        });
        $("#btn3").click(function nextPage(){    // 下一页
            direct=1;
            displayPage();
        });
        $("#btn4").click(function lastPage(){    // 尾页
            curPage=page;
            direct = 0;                  displayPage();
        });
        $("#btn5").click(function changePage(){    // 转页
            curPage=document.getElementById("changePage").value * 1;

            if (!/^[1-9]\d*$/.test(curPage)) {
                alert("请输入正整数");
                return ;
            }
            if (curPage > page) {
                alert("超出数据页面");
                return ;
            }
            direct = 0;
            displayPage();
        });


        $("#pageSizeSet").click(function setPageSize(){    // 设置每页显示多少条记录
            pageSize = document.getElementById("pageSize").value;    //每页显示的记录条数
            if (!/^[1-9]\d*$/.test(pageSize)) {
                alert("请输入正整数");
                return ;
            }
            len =$("#mytable tr").length - 1;
            page=len % pageSize==0 ? len/pageSize : Math.floor(len/pageSize)+1;//根据记录条数，计算页数
            curPage=1;        //当前页
            direct=0;        //方向
            firstPage();
        });
    });

    function displayPage(){
        if(curPage <=1 && direct==-1){//
            direct=0;
            alert("已经是第一页了");
            return;
        } else if (curPage >= page && direct==1) {
            direct=0;
            alert("已经是最后一页了");
            return ;
        }

        lastPage = curPage;
        //修复当len=1时，curPage计算得0的bug
        if (len > pageSize) {
            curPage = ((curPage + direct + len) % len);
        } else {
            curPage = 1;
        }


        document.getElementById("btn0").innerHTML="当前 " + curPage + "/" + page + " 页    每页 ";        // 显示当前多少页

        begin=(curPage-1)*pageSize + 1;// 起始记录号
        end = begin + 1*pageSize - 1;    // 末尾记录号


        if(end > len ) end=len;
        $("#mytable tr").hide();    // 首先，设置这行为隐藏
        $("#mytable tr").each(function(i){    // 然后，通过条件判断决定本行是否恢复显示
            if((i>=begin && i<=end) || i==0 )//显示begin<=x<=end的记录
                $(this).show();
        });

    }
</script>
</body>
</html>