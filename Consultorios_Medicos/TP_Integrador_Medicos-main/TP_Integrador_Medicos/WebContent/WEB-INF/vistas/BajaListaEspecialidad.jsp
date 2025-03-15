<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Baja y Listado de Especialidades</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }
        .header, .footer {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 10px 0;
        }
        .container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 80%;
            max-width: 800px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .btn {
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            border-radius: 4px;
            margin-top: 10px;
        }
        .btn:hover {
            background-color: #45a049;
        }
        .button-container {
            text-align: right;
        }
        .delete-btn {
            background-color: #f44336;
        }
        .delete-btn:hover {
            background-color: #e53935;
        }
    </style>
</head>
<body>
<div class="header">
<h1>Baja y Listado de Especialidades</h1>
</div>
    <div class="container">
    <a href="homeAdmin.html" class="btn">Volver al Home</a>
        <c:if test="${not empty resultadoEliminar}">
            <div>${resultadoEliminar}</div>
        </c:if>
        <c:if test="${not empty resultadoGuardar}">
            <div>${resultadoGuardar}</div>
        </c:if>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="especialidad" items="${especialidades}">
                    <tr>
                        <td>${especialidad.id}</td>
                        <td>${especialidad.nombre}</td>
                        <td>
                            <a class="btn delete-btn" href="${pageContext.request.contextPath}/borrarEspecialidad.html?id=${especialidad.id}">Eliminar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div class="button-container">
            <a href="${pageContext.request.contextPath}/altaEspecialidad.html" class="btn">Agregar Especialidad</a>
        </div>
        
    </div>
    <div class="footer">
        <p>&copy; 2024 Sistema de Gestión Médica</p>
    </div>
</body>
</html>
