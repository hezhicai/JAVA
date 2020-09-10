<%--
  Created by IntelliJ IDEA.
  User: hezhicai
  Date: 2020/6/26
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true"  language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
 <%
    String str="网银少奶奶";
    out.write("我是书");
     out.newLine();
      String [] str1={"212","2313","32132"};
 %>
  <%="sad"%>
 <br>
 <%=str%>
 <%session.setAttribute("hehhe","网吧");%>
 <%=session.getAttribute("hehhe")%>
<%pageContext.setAttribute("何","智才");%>
<%application.setAttribute("李","智才");%>

  ${a && b}
 <br>
  ${2 div 30}
 <br>
  ${2+2}
  ${4*7}
 <br>
  ${sessionScope.hehhe}
 <hr>
  ${pageScope.何}
 <br>
  ${applicationScope.李}
  ${empty str1}
  ${not empty str}
   </body>
</html>
