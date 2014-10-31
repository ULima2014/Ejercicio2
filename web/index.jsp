<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>..::Login::..</title>
        <c:set var="error" value="${sessionScope.error}" scope="session"/>
    </head>
    <body>
        <div>
            <h1>Logueate</h1>
            <form action="s01" method="POST">
                <table border="2">
                    <tr>
                        <td>Codigo</td>
                        <td><input type="text" id="usuario" name="usuario"/></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" id="password" name="password"/></td>
                    </tr>
                </table>
                <input type="submit" value="Login"/>
            </form>
            <a href="s02">Registrate</a>
        </div>
        <div>
            <c:if test="${error != null}">
                <h2>${error}</h2>
            </c:if>
        </div>
        
    </body>
</html>
