<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <script>
        window.onload = function(){
            document.getElementById("img").onclick = function(){
                this.src="/cookie__jsp_war_exploded/checkCodeServlet?time="+new Date().getTime();
            }
        }
    </script>
    <style>
        div{
            color: red;
        }

    </style>
</head>
<body>
    <form action="/cookie__jsp_war_exploded/loginServlet" method="post">
        <table>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>验证码</td>
                <td><input type="text" name="checkCode"></td>
            </tr>
            <tr>
                <td colspan="2"><img id="img" src="/cookie__jsp_war_exploded/checkCodeServlet"></td>

            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="登录"></td>
            </tr>
        </table>
    </form>
    <div><%=request.getAttribute("cc_error") == null ? "" : request.getAttribute("cc_error")%></div>
    <div><%=request.getAttribute("login_error") == null ? "" : request.getAttribute("login_error") %></div>
</body>
</html>
