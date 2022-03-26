<%-- 
    Document   : totalEmpleado
    Created on : 01-feb-2019, 10:35:11
    Author     : José
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Viáticos</title>
    </head>
    <body>
        <h1>Total por Empleado</h1>
        
        <table border="1">
            
            <tr><th>Nombre</th><th>Total de Gastos</th></tr>
            
            <c:forEach items="${lista}" var="E">
                <tr><td>${E.nombre}</td><td>${E.importe}</td></tr>
            </c:forEach>
        </table>
        <br>
        <br>
        <a href="index.html">Volver</a>
    </body>
</html>
