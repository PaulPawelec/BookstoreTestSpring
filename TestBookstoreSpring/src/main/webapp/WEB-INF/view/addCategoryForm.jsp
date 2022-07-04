<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Categories</title>
</head>

<body>
ADD Category
<form:form action="saveCategory" modelAttribute="category" method="POST">
    <table>
        <tbody>
        <tr>
            <td><label>Name:</label></td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td><label></label></td>
            <td><input type="submit" value="Save" class="save" /></td>
        </tr>
        </tbody>
    </table>
</form:form>
<p>
    <a href="${pageContext.request.contextPath}/categories/list "> return </a>
</p>
</body>
</html>