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
    <a href="/userFigureList" class="button">User Figures List</a>

    <form method="post" action="/figureList">
        <table>
            <thead>
                <tr>
                    <th>User</th>
                    <th>FigureName</th>
                    <th>Type</th>
                    <th>PosX</th>
                    <th>PosY</th>
                    <th>Width</th>
                    <th>Color</th>
                    <th>Options</th>
                </tr>
            </thead>
    </form>
    <c:forEach var="figure" items="${figure}">
        <tbody>
            <tr>
                <td>${figure.user.getName()}</td>
                <td>${figure.name}</td>
                <td>${figure.figureType}</td>
                <td>${figure.coordX}</td>
                <td>${figure.coordY}</td>
                <td>${figure.width}</td>
                <td>${figure.color}</td>
                <td>
                    <form method="post" action="/figureList">
                        <input type="hidden" value=${figure.id} name="figureId">
                        <input type="submit" value="View" class="options">
                    </form>
                    <c:if test="${figure.user.getId() == user.getId()}">
                        <form method="post" action="/figureDelete">
                            <input type="hidden" value=${figure.id} name="figureId">
                            <input type="submit" value="Delete" class="options">
                        </form>
                    </c:if>
                </td>
            </tr>
    </c:forEach>
    </tbody>
    </table>
</body>

</html>