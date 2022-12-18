<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <body>
        <table>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.username}, ${user.name} ${user.surname}</td>
                <tr>
            </c:forEach>
        </table>
        <a href="${pageContext.request.contextPath}/main">back </a>
    </body>
</html>
