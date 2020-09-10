<%@ page import="domain.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%--
  Created by IntelliJ IDEA.
  User: hezhicai
  Date: 2020/6/26
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取对象</title>

</head>
<body>
<%
    User user=new User();
    user.setName("李白");
    user.setGender("男");
    request.setAttribute("李白",user);
    List list=new ArrayList();
    list.add(user);
    list.add("杜甫");
    request.setAttribute("list",list);
    Map map=new HashMap();
    map.put("user",user);
    map.put("02","杜甫");
    request.setAttribute("map",map);
%>
<h4>User对象</h4><br>
${requestScope.李白}<br>
${李白}<br>
${李白.gender}<br>
${李白.name}<br>
${empty 李白}<br>
<h4>list对象</h4>
${requestScope.list}<br>
${requestScope.list[0]}<br>
${requestScope.list[0].name}<br>
${requestScope.list[0].gender}<br>
${requestScope.list[1]}<br>
${not empty list}<br>
<h4>map对象</h4>
${requestScope.map}<br>
${requestScope.map.user}<br>
${requestScope.map.user.name}<br>
${requestScope.map.user.gender}<br>
${requestScope.map["01"]}<br>
${requestScope.map["02"]}<br>
${empty map}
</body>
</html>
