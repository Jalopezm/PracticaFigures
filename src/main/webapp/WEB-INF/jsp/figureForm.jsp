<%@ page isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head></head>
<body>
<h1>Figure Form</h1>
    <form>
    <label for="figure">Choose a Figure:</label>

    <select name="figures" id="figures">
      <option value="circle">Circle</option>
      <option value="rectagle">Rectangle</option>
      <option value="triangle">Triangel</option>
      <option value="square">Square</option>
    </select>
    </form>
    ${msg}
</body>
</html>