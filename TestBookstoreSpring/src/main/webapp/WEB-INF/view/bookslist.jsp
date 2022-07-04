<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <%@include file="parts/header.jsp"%>
    <title>List books</title>

    <script type="text/javascript">
        function disableButton(btn){
            document.getElementById(btn.id).disabled = true;
        }
    </script>

</head>
<body>
<h2>Books:</h2>

<sec:authorize access="hasRole('ADMIN')">
    <div>
        <input type="button" value="Add Book"
               onclick="window.location.href='bookAdd';return false;" />
    </div>
</sec:authorize>

<div>
    <table>
        <tr>
            <th>Name</th>
            <th>Publisher</th>
            <th>Price</th>
            <th>Category</th>
<%--            <th>Author</th>--%>
            <sec:authorize access="hasRole('USER')">
                <th>   </th>
            </sec:authorize>
            <sec:authorize access="hasRole('ADMIN')">
                <th>Delete</th>
            </sec:authorize>
        </tr>
        <c:forEach var="books" items="${books}" varStatus="loop">
            <tr>
                <td>${books.name}</td>
                <td>${books.publisher}</td>
                <td>${books.price}</td>
                <td>${books.category.name}</td>
<%--                <td>${books.authors}--%>
<%--                    <c:forEach var="data" items="${books.authors}" >--%>
<%--                        <c:out value="${data.name}">  </c:out>--%>
<%--                    </c:forEach>--%>
<%--                </td>--%>
                <sec:authorize access="hasRole('USER')">
                <td>
                    <form:form action="${pageContext.request.contextPath}/cart/add">
                        <input type="hidden" id="bookId" name="bookId" value="${books.id}"/>
                        <button type="submit">Add to Cart</button>
<%--                        id="btn_add_${loop.index}" onclick="disableButton(this)"--%>
                    </form:form>
                </td>
                </sec:authorize>
                <sec:authorize access="hasRole('ADMIN')">
                <td>
                    <form:form action="${pageContext.request.contextPath}/books/deleteBook">
                        <input type="hidden" id="bookId" name="bookId" value="${books.id}"/>
                        <button type="submit" >Delete</button>
                    </form:form>
                </td>
                </sec:authorize>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>