<%@ page isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head></head>
<h1>Login</h1>

    <form method="post" action="/login">
    Name: <input type="text" name="user">
    <br>
    Password: <input type="password" name="pass">
    <br>
    ${msg}
    <br>
    <input type="submit" name="Send">
    </form>

    <h1>Register</h1>
        <form method="post" action="/login">
        Name: <input type="text" name="userR">
        <br>
        Password: <input type="password" name="passR">
        <br>
        ${msg}
        <br>
        <input type="submit" name="Send">
        </form>
</body>
</html>