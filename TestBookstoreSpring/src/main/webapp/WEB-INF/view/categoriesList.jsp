<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <%@include file="parts/header.jsp"%>
    <title>List categories</title>
</head>
<body>
<h2>Categories:</h2>

<sec:authorize access="hasRole('ADMIN')">
    <div>
        <input type="button" value="Add Category"
               onclick="window.location.href='categoryAdd';return false;" />
    </div>
</sec:authorize>

<div>
    <table>
        <tr>
            <th>Nazwa</th>
        </tr>
        <c:forEach var="categories" items="${categories}" >
            <tr>
                <td>${categories.name}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>