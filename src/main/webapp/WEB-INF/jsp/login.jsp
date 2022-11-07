<%@ page isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <style>
        <%@include file="/WEB-INF/css/style.css" %>
    </style>
</head>

<body class="login">
    <div id="login">
        <form method="post" action="/login">
            <h1>Login</h1>
            <input type="text" name="nameUser" id="nameUser" placeholder="Username">
            <c:if test="${not empty error}">
                <p>Introduce almenos un caracter</p>
            </c:if>
            <button><input type="submit" name="Send" value="Send"></button>
        </form>
    </div>
</body>

</html>