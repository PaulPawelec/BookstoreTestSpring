<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>books</title>
    </head>

    <body>
        ADD BOOK
        <form:form action="saveBook" modelAttribute="book" method="POST">
            <table>
                <tbody>
                <tr>
                    <td><label>nazwa:</label></td>
                    <td><form:input path="name" /></td>
                </tr>
                <tr>
                    <td><label>wydawnictwo:</label></td>
                    <td><form:input path="publisher" /></td>
                </tr>
                <tr>
                    <td><label>cena:</label></td>
                    <td><form:input path="price" /></td>
                </tr>
                <tr>
                    <td><label>kategoria:</label></td>
                    <td>
                        <label>
                            <select name="category.id">
                                <c:forEach items="${categoryList}" var="category">
                                    <option value="${category.id}">${category.name}</option>
                                </c:forEach>
                            </select>
                        </label>

                    </td>
                </tr>
                <tr>
                    <td><label>Author: </label></td>
                    <td>
                        <label>
                            <select name="author.id">
                                <c:forEach items="${authorsList}" var="author">
                                    <option value="${author.id}">${author.name} ${author.surname}</option>
                                </c:forEach>
                            </select>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="Save" class="save" /></td>
                </tr>
                </tbody>
            </table>
        </form:form>
        <p>
         <a href="${pageContext.request.contextPath}/books/list "> return </a>
        </p>
    </body>
</html>