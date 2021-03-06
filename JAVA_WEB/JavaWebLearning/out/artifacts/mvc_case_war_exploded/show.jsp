<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <SCRIPT>
        //删除是否选中
        function ifdelete(id) {
            if(confirm("确定删？")){
                location.href="${pageContext.request.contextPath
                }/DeleteServlet?id="+id;
            }
        }
        //删除选中按钮
        window.onload = function(){
            //给删除选中按钮添加单击事件
            document.getElementById("delSelected").onclick = function(){
                if(confirm("您确定要删除选中条目吗？")){

                    var flag = false;
                    //判断是否有选中条目
                    var cbs = document.getElementsByName("uid");
                    for (var i = 0; i < cbs.length; i++) {
                        if(cbs[i].checked){
                            //有一个条目选中了
                            flag = true;
                            break;
                        }
                    }

                    if(flag){//有条目被选中
                        //表单提交
                        document.getElementById("form").submit();
                    }

                }

            }
            //1.获取第一个cb
            document.getElementById("firstCb").onclick = function(){
                //2.获取下边列表中所有的cb
                var cbs = document.getElementsByName("uid");
                //3.遍历
                for (var i = 0; i < cbs.length; i++) {
                    //4.设置这些cbs[i]的checked状态 = firstCb.checked
                    cbs[i].checked = this.checked;

                }

            }
        }
    </SCRIPT>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <div style="float: left;">
        <%--        表单没提交  我找了半天--%>
        <form class="form-inline" action="${pageContext.request.contextPath}/findUserByPageServlet" method="post">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" class="form-control" name="name" value="${requestScope.condition.name[0]}" id="exampleInputName2" >
            </div>
            <div class="form-group">
                <label for="exampleInputName3">籍贯</label>
                <input type="text" class="form-control" name="address" value="${requestScope.condition.address[0]}" id="exampleInputName3" >
            </div>
            <div class="form-group">
                <label for="exampleInputEmail2">邮箱</label>
                <input type="email" class="form-control" name="email"  value="${requestScope.condition.email[0]}" id="exampleInputEmail2"  >
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>
    <div style="float: right;margin: 5px;">

        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加联系人</a>
        <a class="btn btn-primary" href="javascript:void (0);" id="delSelected">删除选中</a>

    </div>
<form id="form" action="${pageContext.request.contextPath}/DeleteSeletedServlet" method="post">
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th><input type="checkbox" id="firstCb"></th>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${requestScope.pb.list}" var="user" varStatus="s">
            <tr>
                <td><input type="checkbox" name="uid" value="${user.id}"></td>
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.gender}</td>
                <td>${user.age}</td>
                <td>${user.address}</td>
                <td>${user.qq}</td>
                <td>${user.email}</td>
                <td><a class="btn btn-primary btn-sm" href="${pageContext.request.contextPath}/getUserMessageServlet?id=${user.id}">修改</a>&nbsp;
                    <a class="btn btn-danger btn-sm" href="javascript:ifdelete(${user.id});">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</form>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
<%--                向前 进一页--%>
                <c:if test="${requestScope.pb.currentPage<=1}">
                    <li class="disabled">
                    <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=1&rows=5&name=${requestScope.condition.name[0]}&address=${requestScope.condition.address[0]}&email=${requestScope.condition.email[0]}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                </c:if>
                <c:if test="${requestScope.pb.currentPage>1}">
                    <li>
                    <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${requestScope.pb.currentPage-1}&rows=5&name=${requestScope.condition.name[0]}&address=${requestScope.condition.address[0]}&email=${requestScope.condition.email[0]}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                </c:if>
<%--页码--%>
<c:forEach begin="1" end="${requestScope.pb.totalPage}" var="i">
    <c:if test="${requestScope.pb.currentPage==i}">
        <li class="active">
            <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=5&name=${requestScope.condition.name[0]}&address=${requestScope.condition.address[0]}&email=${requestScope.condition.email[0]}">${i}</a>
        </li>
    </c:if>
    <c:if test="${requestScope.pb.currentPage!=i}">
        <li>
            <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=5&name=${requestScope.condition.name[0]}&address=${requestScope.condition.address[0]}&email=${requestScope.condition.email[0]}">${i}</a>
        </li>
    </c:if>
</c:forEach>
<%-- 向后移动--%>
    <c:if test="${requestScope.pb.currentPage>=requestScope.pb.totalPage}">
        <li class="disabled">
            <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${requestScope.pb.totalPage}&rows=5&name=${requestScope.condition.name[0]}&address=${requestScope.condition.address[0]}&email=${requestScope.condition.email[0]}" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </c:if>
    <c:if test="${requestScope.pb.currentPage<requestScope.pb.totalPage}">
        <li>
            <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${requestScope.pb.currentPage+1}&rows=5&name=${requestScope.condition.name[0]}&address=${requestScope.condition.address[0]}&email=${requestScope.condition.email[0]}" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </c:if>
<%--           底部统计条     --%>
                <span style="font-size: 25px;margin-left: 5px;">
                    共${requestScope.pb.totalCount}条记录，共${requestScope.pb.totalPage}页
                </span>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>
