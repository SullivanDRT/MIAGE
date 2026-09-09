
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html lang="fr">
<head>
    <title>METEO</title>
    <meta charset="utf-8">
</head>
<body>

<!-- implanter ici le nombre de fois où chaque option de météo a été validée -->

<form method="post">
    <select name="meteo">
        <c:forEach items="${options}" var="opt">
        <option value="${opt}">${opt}</option>
        </c:forEach>
    </select>
    <button type="submit">Valider</button>
</form>

</body>
</html>
