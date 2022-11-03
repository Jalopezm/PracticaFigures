<%@ page isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<style>
table, th, td {
  border:1px solid black;
}
</style>
<head></head>
<h1>Figure List</h1>
<form method="post" action="/figureList">
    <table>
        <tr>
        <th>User</th>
        <th>FigureName</th>
        <th>Type</th>
        <th>PosX</th>
        <th>PosY</th>
        <th>Width</th>
        <th>Color</th>
        </tr>
</form>
<c:forEach var="figure" items="${figure}">
    <tr>
    <td>${figure.user}</td>
    <td>${figure.name}</td>
    <td>${figure.figureType}</td>
    <td>${figure.coordX}</td>
    <td>${figure.coordY}</td>
    <td>${figure.width}</td>
    <td>${figure.color}</td>
    <td><form method ="post" action="/figureList">
        <input type="hidden" value=${figure.id} name="figureId">
        <input type="submit" value="View">
    </form></td>
    <td><form method="post" action="/figureList">
            <input type="hidden" value=${figure.id} name="figureId">
            <input type="submit" value="Delete">
    </form></td>
    </tr>
        </table>
</c:forEach>
</body>
</html>