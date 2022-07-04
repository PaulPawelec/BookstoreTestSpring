<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.2.1/dist/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

    <title>BOOOKstore!</title>
</head>
<body>
<nav class="nav nav-pills nav-fill">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">BOOKstore</a>
    <a class="nav-link" href="${pageContext.request.contextPath}/">Home <span class="sr-only">(current)</span></a>

    <sec:authorize access="isAnonymous()">
    <a class="nav-link" href="login">LOGIN</a>
    </sec:authorize>

    <sec:authorize access="hasRole('USER')">
        <a class="nav-link" href="${pageContext.request.contextPath}/cart">CART</a>
    </sec:authorize>

    <sec:authorize access="isAnonymous()">
        <a class="nav-link" href="register">REGISTER</a>
    </sec:authorize>

    <sec:authorize access="isAuthenticated()">
        <form:form action="${pageContext.request.contextPath}/logout" method="POST">
            <input class="nav-link" type="submit" value="Logout" />
        </form:form>
    </sec:authorize>
</nav>
</body>
</html>