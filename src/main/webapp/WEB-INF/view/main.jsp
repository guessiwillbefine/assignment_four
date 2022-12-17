<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <body>
        <c:forEach items="${users}" var="user">
            <div>${user.username}, ${user.name} ${user.surname}</div>
        </c:forEach><br/>
        <hr>
        <a href="${pageContext.request.contextPath}/main/logout">logout</a>
    </body>
</html>
