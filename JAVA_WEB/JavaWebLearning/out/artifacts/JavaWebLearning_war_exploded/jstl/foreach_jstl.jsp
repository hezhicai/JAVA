<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: hezhicai
  Date: 2020/6/26
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="S" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>foreach</title>
    <%--

    foreach:相当于java代码的for语句
        1. 完成重复的操作
            for(int i = 0; i < 10; i ++){

            }
            * 属性：
                begin：开始值
                end：结束值
                var：临时变量
                step：步长
                varStatus:循环状态对象
                    index:容器中元素的索引，从0开始
                    count:循环次数，从1开始
        2. 遍历容器
            List<User> list;
            for(User user : list){

            }

            * 属性：
                items:容器对象
                var:容器中元素的临时变量
                varStatus:循环状态对象
                    index:容器中元素的索引，从0开始
                    count:循环次数，从1开始


--%>
</head>
<body>
<%
    Map hash=new HashMap();
    hash.put("a","李白");
    hash.put("b","杜甫");
    hash.put("c","欧阳修");
    request.setAttribute("hash",hash);
%>
<s:forEach begin="0" end="10" step="1" var="i" varStatus="c">
 ${i}
 ${c.index}
    ${c.count}
    ${c.current}
    ${c.first}
    ${c.last}
    <br>
</s:forEach>
<s:forEach items="${hash}" var="val" varStatus="s">
${s.index}
    ${s.current}
    ${s.count}
    <br>
</s:forEach>
</body>
</html>
