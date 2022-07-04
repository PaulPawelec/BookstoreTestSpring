<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="parts/header.jsp"%>
    <title>Home</title>
</head>
<body>
    Every book is for you!
    <br><br>
    <sec:authorize access="isAuthenticated()">
    <a href="books/list"> Book List </a>
    <br>
    <a href="categories/list"> Category List </a>
    <br>
    <a href="authors/list"> Author List </a>
    <br>
    </sec:authorize>

    <sec:authorize access="hasRole('USER')">
        <a href="orders/list"> My Orders List </a>
    </sec:authorize>

    <sec:authorize access="hasRole('ADMIN')">
        <a href="orders/listAdmin"> ALL Orders List </a>
    </sec:authorize>
</body>
</html>
