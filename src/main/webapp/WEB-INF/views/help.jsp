<%@ page import="java.time.LocalDateTime" %><%--
  Created by IntelliJ IDEA.
  User: RohitKumarSingh
  Date: 29-07-2024
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Help</title>
</head>
<body>
<%
    String name1 = (String) request.getAttribute("name");
    Integer rollNumber = (Integer) request.getAttribute("rollNumber");
    LocalDateTime time = (LocalDateTime) request.getAttribute("time");
%>
<h1>My name is <%=name1%></h1>
<h1>My roll number is <%=rollNumber%></h1>
<h1>This is help page.</h1>
<h1>Date and time is <%=time%></h1>
<h1>My name is ${name}</h1>
</body>
</html>
