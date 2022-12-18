<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Registration form</title>
    </head>
<body>
    <form:form action="/auth/registration" method="POST" modelAttribute="user">
        <form:label path="username">username</form:label>
        <form:input type="text" path="username"/> <br/>
        <form:label path="password">password</form:label>
        <form:input type="password" path="password"/><br/>
        <form:label path="name">name</form:label>
        <form:input type="text" path="name"/><br/>
        <form:label path="surname">surname</form:label>
        <form:input type="text" path="surname"/><br/>
        <input type="submit" value="registration">
    </form:form>
    <c:if test="${invalid eq \"true\"}">
        <div>invalid data</div>
    </c:if> <br/>
</body>
</html>
