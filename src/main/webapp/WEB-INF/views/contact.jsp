<%--
  Created by IntelliJ IDEA.
  User: RohitKumarSingh
  Date: 30-07-2024
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Contact</title>
</head>
<body>
<h1>This is contact page</h1>
<h2>My name is ${name}. You can contact me at ${phone}</h2>
<c:forEach var="item" items="${list}">
    <h4>${item}</h4>
</c:forEach>
</body>
</html>
