<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>..::Registrate::..</title>
        <c:set var="carreras" value="${sessionScope.carreras}" scope="session"/>
    </head>
    <body>
        <h1>Datos personales:</h1>
        <form action="s03" method="POST">
            <p>Codigo: <input type="text" name="codigo"/></p>
            <p>Password: <input type="password" name="password"/></p>
            <p>Nombre: <input type="text" name="nombre"/></p>
            <p>Apellidos: <input type="text" name="apellido"/></p>
            <div>Sexo:
                <div><input type="radio" name="sexo" value="Femenino"/>Femenino</div>
                <div><input type="radio" name="sexo" value="Masculino"/>Masculino</div>
            </div>
            <div>Carrera:
                <div>
                    <select name="carreraElegida">
                        <c:forEach var="c" items="${carreras}">
                            <option value="${c.pkeycarrera}">${c.nombre}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <input type="submit" value="Registrate"/>
        </form>
    </body>
</html>
