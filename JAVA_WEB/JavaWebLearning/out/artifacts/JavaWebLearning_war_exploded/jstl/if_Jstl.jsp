<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: hezhicai
  Date: 2020/6/26
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <title>if语句</title>
</head>
<body>
<%
    List list=new ArrayList();
    list.add("一百");
    list.add("二百");
    list.add("三百");
    request.setAttribute("list",list);
%>
<s:if test="${not empty list}">
    ${requestScope.list[0]}<br>
    ${requestScope.list[1]}<br>
    ${requestScope.list[2]}<br>
</s:if>



</body>
</html>
