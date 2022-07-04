<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <%@include file="parts/header.jsp"%>
    <title>Cart</title>
</head>
<body>
<h2>Cart:</h2>
<div>
    <c:set var="totalPrice" value="${0}"/>
    <table>
        <tr>
            <th>Name</th>
            <th>Publisher</th>
            <th>Price</th>
            <th>Category</th>
            <sec:authorize access="hasAuthority('ROLE_USER')">
                <th>Do koszyka</th>
            </sec:authorize>
        </tr>
        <c:forEach var="books" items="${books}" >
            <tr>
                <td>${books.name}</td>
                <td>${books.publisher}</td>
                <td>${books.price}</td>
                <td>${books.category.name}</td>
                <td>
                    <form:form action="${pageContext.request.contextPath}/cart/delete">
                        <input type="hidden" id="bookId" name="bookId" value="${books.id}"/>
                        <button type="submit">Delete</button>
                    </form:form>
                </td>
            </tr>
            <c:set var="totalPrice" value="${totalPrice + books.price}"/>
        </c:forEach>
    </table>
</div>

<div>
    Total cost: <fmt:formatNumber type="number" maxFractionDigits="3" value="${totalPrice}"/>
    <br><br>

    <form:form action="${pageContext.request.contextPath}/orders/add">
<%--        <input type="hidden" id="totalPrice" name="totalPrice" value=totalPrice/>--%>
        <button type="submit" >Order</button>
    </form:form>
</div>
</body>
</html>