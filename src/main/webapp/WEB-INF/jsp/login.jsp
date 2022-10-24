<%@ page isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>Login</head>
<body>
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
</body>
</html>