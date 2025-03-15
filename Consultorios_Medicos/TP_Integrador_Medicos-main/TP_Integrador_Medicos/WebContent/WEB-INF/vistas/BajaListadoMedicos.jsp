<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Baja y Listado de Médicos</title>
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
            width: 90%;
            margin: auto;
            overflow: hidden;
        }
        .content {
            background-color: white;
            padding: 20px;
            margin-top: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            overflow-x: auto;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        a {
            color: #007bff;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
        input[type="text"], input[type="submit"], select {
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #28a745;
            color: white;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #218838;
        }
        .inline-inputs {
            display: flex;
            align-items: center;
        }
        .inline-inputs input {
            width: auto;
            margin-right: 5px;
        }
        .actions form {
            display: inline-block;
        }
        .actions input[type="submit"] {
            margin-right: 5px;
        }
        .pagination {
            display: flex;
            justify-content: center;
            margin-top: 20px;
        }
        .pagination a {
            margin: 0 5px;
            padding: 10px 15px;
            border: 1px solid #ddd;
            border-radius: 5px;
            text-decoration: none;
            color: #007bff;
        }
        .pagination a.active {
            background-color: #007bff;
            color: white;
        }
        .pagination a:hover {
            background-color: #ddd;
        }
        .center {
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>Baja y Listado de Médicos</h1>
    </div>
    <div class="container">
        <div class="content">
            <table>
                <tr>
                    <td class="columnaLateral"><b><a href="homeAdmin.html">Volver a Home</a></b></td>
                    <td class="columnaCentral">
                    	<c:choose>
                            <c:when test="${param.btnBuscar == 'Buscar'}">
                                <form action="listarMedicos.html" method="GET">
									Filtrando por ${param.txtNombre}
                                    <input type="submit" name="btnBuscar" value="volver">
                                </form>
                            </c:when>
                            <c:otherwise>
                                <form action="buscarMedicoDinamico.html" method="GET">
                                    Buscar médico por Nombre o Apellido: 
                                    <input type="text" required name="txtNombre">
                                    <input type="submit" name="btnBuscar" value="Buscar">
                                </form>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td class="columnaCentral">
                        <form action="listarMedicosFiltro.html" method="GET">
                            Filtrar por: 
                            <select name="ddlFiltroEstado">
                                <option value="true" ${ddlFiltroEstado == 'true' ? 'selected' : ''}>Médicos Disponibles</option>
                                <option value="false" ${ddlFiltroEstado == 'false' ? 'selected' : ''}>Médicos No Disponibles</option>
                            </select>
                            <input type="submit" name="btnFiltrar" value="Filtrar">
                        </form>

						<form action="listarMedicos.html" method="GET">
                			<input type="submit" name="btnBuscar" value="Borrar Filtros">
            			</form>
                    </td>
                    <td class="columnaLateral center"><a href="inicio.html"><b>Cerrar Sesión</b></a></td>
                </tr>
            </table>

            ${mensaje}

            <div class="table-responsive">
                <table class="tabla">
                    <tr>
                        <th>Legajo</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Fecha de Nacimiento</th>
                        <th>Dirección</th>
                        <th>Localidad</th>
                        <th>Sexo</th>
                        <th>Especialidad</th>
                        <th>Teléfono</th>
                        <th>Días que Trabaja</th>
                        <th>Horario de Entrada</th>
                        <th>Horario de Salida</th>
                        <th>Usuario</th>
                        <th>Estado</th>
                        <th>Acciones</th>
                    </tr>
                    <c:forEach var="medico" items="${medicos}">
                        <tr>
                            <td>${medico.legajo}</td>
                            <td>${medico.nombre}</td>
                            <td>${medico.apellido}</td>
                            <td>${medico.fechaNacimiento}</td>
                            <td>${medico.direccion}</td>
                            <td>${medico.localidad}</td>
                            <td>${medico.sexo}</td>
                            <td>${medico.especialidad.nombre}</td>
                            <td>${medico.telefono}</td>
                            <td>${medico.diasQueTrabaja}</td>
                            <td>${medico.horaEntrada}</td>
                            <td>${medico.horaSalida}</td>
                            <td>${medico.usuario.nombre_usuario}</td>
                            <td>${medico.estado ? "Disponible" : "No disponible"}</td>
                            <td class="actions">
                                <c:choose>
                                    <c:when test="${medico.estado}">
                                        <form action="${pageContext.request.contextPath}/bajaMedico.html" method="post">
                                            <input type="hidden" name="legajo" value="${medico.legajo}" />
                                            <input type="submit" onclick="return confirm('¿Seguro que desea dar de baja este médico?');" value="Baja Lógica" />
                                        </form>
                                    </c:when>
                                    <c:otherwise>
                                        <form action="${pageContext.request.contextPath}/cambiarAltaMedico.html" method="post">
                                            <input type="hidden" name="legajo" value="${medico.legajo}" />
                                            <input type="submit" onclick="return confirm('¿Seguro que desea dar de alta este médico?');" value="Alta Lógica" />
                                        </form>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
	<c:choose>
    <c:when test="${not noResultados}">
        <c:choose>
		<c:when test="${busqueda}">
		<div class="pagination">
                <c:forEach var="i" begin="0" end="${totalPages - 1}">
                    <a href="buscarMedicoDinamico.html?page=${i}&txtNombre=${param.txtNombre}" class="${i == currentPage ? 'active' : ''}">${i + 1}</a>
                </c:forEach>
            </div>
		</c:when>
		<c:when test="${filtro}">
		<div class="pagination">
                <c:forEach var="i" begin="0" end="${totalPages - 1}">
                    <a href="listarMedicosFiltro.html?page=${i}&ddlFiltroEstado=${ddlFiltroEstado}" class="${i == currentPage ? 'active' : ''}">${i + 1}</a>
                </c:forEach>
            </div>
		</c:when>
		<c:otherwise>
		<div class="pagination">
                <c:forEach var="i" begin="0" end="${totalPages - 1}">
                    <a href="listarMedicos.html?page=${i}&ddlFiltroEstado=${ddlFiltroEstado}" class="${i == currentPage ? 'active' : ''}">${i + 1}</a>
                </c:forEach>
            </div>
		</c:otherwise>
	</c:choose>
    </c:when>
    <c:otherwise>
        <div class="alert alert-warning">
            ${errorBusquedaNula}
        </div>
    </c:otherwise>
</c:choose>
        </div>
    </div>
    <div class="footer">
        <p>&copy; 2024 Sistema de Gestión Médica</p>
    </div>
</body>
</html>
