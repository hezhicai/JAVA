<%@ page import="domain.User" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: hezhicai
  Date: 2020/6/26
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>example</title>
</head>
<body>
<%
    HashMap hashMap=new HashMap();
    hashMap.put("k1",new User("杜甫","男",new Date(88, Calendar.JANUARY,13)));
    hashMap.put("k2",new User("李白","男",new Date(8,Calendar.FEBRUARY,3)));
    hashMap.put("k3",new User("欧阳修","男",new Date(48,Calendar.AUGUST,6)));
    request.setAttribute("hash",hashMap);

%>

<table border="1" align="center">
    <tr bgcolor="blue">
        <th>编号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>生日</th>
    </tr>
        <c:forEach items="${hash}" varStatus="s" var="user">
<%--            基数的背景颜色--%>
            <c:if test="${s.count % 2 == 1}">
                <tr bgcolor="#7fffd4">
                <td>${s.count}</td>
                <td>${user.value.name}</td>
                <td>${user.value.gender}</td>
                <td>${s.current.value.bir}</td>
                </tr>
            </c:if>
<%--            偶素的背景颜色--%>
            <c:if test="${s.count % 2 == 0}">
                <tr bgcolor="aqua">
                    <td>${s.count}</td>
                    <td>${user.value.name}</td>
                    <td>${user.value.gender}</td>
                    <td>${s.current.value.bir}</td>
                </tr>
            </c:if>
        </c:forEach>
</table>

</body>
</html>
