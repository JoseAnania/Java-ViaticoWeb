<%-- 
    Document   : altaViatico
    Created on : 01-feb-2019, 10:02:24
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
        <h1>Carga de Viáticos</h1>
        
        <form method="post" action="ServletAltaViatico">
            Empleado: <select name="cboEmpleado" id="cboEmpleado" required="requiered">
                <option value="" disabled selected> Seleccione el Empleado: </option>
                    <c:forEach items="${lista}" var="E">
                        <option value=${E.legajo}>${E.nombre}</option>
                    </c:forEach>               
            </select>
            <br>
            <br>
            <label form="concepto">Concepto: </label>
            <input type="text" name="concepto"/>
            <br>
            <br>
            <label form="importe">Importe: </label>
            <input type="text" name="importe"/>
            <br>
            <br>
            <input type="submit" value="Aceptar"/>
        </form>
        <br>
        <br>
        <a href="index.html">Volver</a>
    </body>
</html>
