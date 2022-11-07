<%@ page isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
<h1>Login</h1>
    <form method="post" action="/login">
    Name: <input type="text" name="nameUser" id="nameUser">
    <c:if test="${not empty error}">
    <p>Introduce almenos un caracter</p>
    </c:if>
    <input type="submit" name="Send" value="Send">
    </form>
</body>
</html>