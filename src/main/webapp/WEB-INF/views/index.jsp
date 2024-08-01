<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: RohitKumarSingh
  Date: 29-07-2024
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>This is home page</h1>
<h1>called by Home Controller</h1>
<%
    String name = (String) request.getAttribute("name");
    List<String> friends = (List<String>) request.getAttribute("f");
%>
<h1>Name is <%=name%>
</h1>
<%
    for (String s : friends) {
%>
<h1><%=s%>
</h1>
<%
    }
%>
</body>
</html>
