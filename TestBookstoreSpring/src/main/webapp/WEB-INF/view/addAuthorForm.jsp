<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Authors</title>
</head>

<body>
ADD Author
<form:form action="saveAuthor" modelAttribute="author" method="POST">
  <table>
    <tbody>
    <tr>
      <td><label>nazwa:</label></td>
      <td><form:input path="name" /></td>
    </tr>
    <tr>
      <td><label>surname:</label></td>
      <td><form:input path="surname" /></td>
    </tr>
    <tr>
      <td><label></label></td>
      <td><input type="submit" value="Save" class="save" /></td>
    </tr>
    </tbody>
  </table>
</form:form>
<p>
  <a href="${pageContext.request.contextPath}/authors/list "> return </a>
</p>
</body>
</html>