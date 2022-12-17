<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
</body>
</html>
