<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true"  language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>用户注册</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
<%--动态的验证码--%>
		function refreshCode() {
			var vcode = document.getElementById("vcode");
			vcode.src="${pageContext.request.contextPath}/checkCodeServlet?time="+new Date().getTime();
		}
<%-- 检测用户名 是否 已经注册了--%>
      $(function () {//函数式接口 相当于 onload
            $("#user").blur(function () {
              //获取 input对象
                var username=$(this).val();//获取input中填写的用户名
                //发送Ajax请求;url -  请求参数   -   回调函数
              //期望服务器响应回的数据格式：{"userExsit":true,"msg":"此用户名太受欢迎,请更换一个"}
              $.get("registerServlet",{name:username},function (data) {//data为服务端传来的Jason对象
                var span = $("#user_name");
                if(data.userExsit){//如果用户名 存在
                  span.css("color","red");
                  span.html(data.msg);
                }
                else{                //用户名不存在  文本颜色为绿色
                  span.css("color","green");
                  span.html(data.msg);
                }
              })
            })
      })
</script>
</head>
<body>
  <div class="container" style="width: 400px;">
      <h3 style="text-align: center;">管理员注册</h3>
    <form action="${pageContext.request.contextPath}/toRegisterServlet" method="post">
      <div class="form-group">
        <label for="user">用户名：</label>
        <input type="text" name="name" class="form-control" id="user" placeholder="请输入用户名"/>
        <span id="user_name"></span>
      </div>

      <div class="form-group">
        <label for="password">密码：</label>
        <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"/>
      </div>
      <div class="form-inline">
        <label for="vcode">验证码：</label>
        <input type="text" name="verifycode" class="form-control" id="verifycode" placeholder="请输入验证码" style="width: 120px;"/>
        <a href="javascript:refreshCode()">
            <img src="${pageContext.request.contextPath}/checkCodeServlet" title="看不清点击刷新" id="vcode"/>
        </a>
      </div>
      <hr/>
      <div class="form-group" style="text-align: center;">
        <input class="btn btn btn-primary" type="submit" value="注册">
        <a href="login.jsp">登录</a>
       </div>
      </form>

    <!-- 出错显示的信息框 -->
      <div class="alert alert-warning alert-dismissible" role="alert">
      <button type="button" class="close" data-dismiss="alert" >
          <span>&times;</span></button>
<%--        显示一次后  清楚数据  --%>
       <strong>${requestScope.register_msg}${pageContext.request.removeAttribute("register_msg")}</strong>
    </div>
  </div>
</body>
</html>