<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <%@include file="parts/header.jsp"%>
    <title>List orders</title>
</head>
<body>
    <h2>Orders:</h2>
    <div>
        <table>
            <tr>
                <th>Price</th>
                <th>Status</th>
                <th>Username</th>
                <th>Books</th>
                <sec:authorize access="hasRole('ADMIN')">
                    <th>Change Status</th>
                </sec:authorize>
            </tr>
            <c:forEach var="orders" items="${orders}" >
                <tr>
                    <td>${orders.price}</td>
                    <td>${orders.status}</td>
                    <td>${orders.username}</td>
                    <td>
                    <c:forEach var="data" items="${orders.books}" >
                        <c:out value="${data.name}">  </c:out>
                    </c:forEach>
                    </td>
                    <sec:authorize access="hasRole('ADMIN')">
                    <td>
                        <form:form action="${pageContext.request.contextPath}/orders/changeStatus">
                            <input type="hidden" id="orderId" name="orderId" value="${orders.id}"/>
                            <button type="submit" >Change Status</button>
                        </form:form>
                    </td>
                    </sec:authorize>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>