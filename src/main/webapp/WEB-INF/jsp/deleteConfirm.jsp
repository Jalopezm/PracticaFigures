<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <style>
        <%@include file="/WEB-INF/css/style.css" %>
    </style>
</head>

<body>
    <a href="/drawer" class="button">Draw Figure</a>
    <a href="/figureList" class="button">Figures List</a>
    <a href="/userFigureList" class="button">User Figures List</a>

    <div id="confirm">
        <form method="post" action="/deleteConfirm">
            <h1>Confirm</h1>
            <input type="submit" value="Yes" name="confirm">
            <input type="submit" value="No" name="confirm">
        </form>
    </div>
</body>

</html>