<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>


<html>
<head>
    <title>Votre première JSP</title>
</head>
<body>
<!-- dans cette JSP on a deux affichages possibles, suivant que "who_is_there" est défini (et de longueur >0) ou pas... -->
<c:if test="${empty who_is_there}">
    <form method="post">
        <label> login
            <input type="text" name="login">
        </label>
        <label> motDePasse
            <input type="password" name="password">
        </label>
        <br/>
        <button type="submit">Envoyer</button>
    </form>
</c:if>




<c:if test="${not empty who_is_there}">
Bienvenu ${login}!
</c:if>
</body>
</html>
