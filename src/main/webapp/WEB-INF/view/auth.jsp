<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <body>
        <h2>Hello!</h2><br/>
        <form:form action="/auth/login" method="GET" modelAttribute="user">
            <form:label path="username">username</form:label>
            <form:input type="text" path="username"/>
            <br>
            <form:label path="password">password</form:label>
            <form:input type="password" path="password"/>
            <br>
            <input type="submit" value="login">
        </form:form>
    <br>
    <a href="/auth/registration">registration</a>
    </body>
</html>