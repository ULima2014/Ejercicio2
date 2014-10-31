<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>..::Bienvenido::..</title>
        <c:set var="actual" value="${sessionScope.actual}" scope="session"/>
    </head>
    <body>
        <h1>Hello: </h1><h2>${actual.nombre}</h2>
        <div>
            <img src="imagenes/${actual.id}.jpg"> 
        </div>
        <div>
            <a href="agregar.jsp">Agregar Estacionamiento</a>
        </div>
        <div>
            <a href="modificar.jsp">Modificar datos</a>
        </div>
            
    </body>
</html>
