<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <%@include file="parts/header.jsp"%>
    <title>List authors</title>
</head>
<body>
<h2>Authors:</h2>

<sec:authorize access="hasRole('ADMIN')">
    <div>
        <input type="button" value="Add Author"
               onclick="window.location.href='authorAdd';return false;" />
    </div>
</sec:authorize>

<div>
    <table>
        <tr>
            <th>Imie</th>
            <th>Nazwisko</th>
        </tr>
        <c:forEach var="authors" items="${authors}" >
            <tr>
                <td>${authors.name}</td>
                <td>${authors.surname}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>