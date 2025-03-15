<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Baja y Listado de Pacientes</title>
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
	<h1>Baja y Listado de Pacientes</h1>
</div>
<div class="container">
<div class="content">
	<table class="tabla">
			<tr>
				<td class="columnaLateral"><b><a href="homeAdmin.html"> Volver a Home </a></b> </td>
				<td class="columnaCentral"></td>
				<td class="columnaCentral"></td>
				<td class="columnaLateral"><a href="inicio.html"><b> Cerrar Sesion</b> </a> </td>
			</tr>
			<tr>
				<td class="columnaLateral">
				<c:choose>
                            <c:when test="${param.btnBuscar == 'Buscar'}">
                                <form action="listarPacientes.html" method="GET">
									Filtrando por ${param.txtNombre}
                                    <input type="submit" name="btnBuscar" value="volver">
                                </form>
                            </c:when>
                            <c:otherwise>
                                <form action="buscarPacienteDinamico.html" method="GET">
                		Buscar paciente por Nombre o Apellido: 
                		<input type="text" required name="txtNombre" style="width: 188px;">
                		<input type="submit" name="btnBuscar" value="Buscar">
            		</form>
                            </c:otherwise>
                        </c:choose>
            </td>
				<td class="columnaCentral">
				<form action="listarPacientesFiltro.html" method="GET">
                		Filtrar por:  
                            <select name="ddlFiltroEstado">
                                <option value="true" ${ddlFiltroEstado == 'true' ? 'selected' : ''}>Pacientes Disponibles</option>
                                <option value="false" ${ddlFiltroEstado == 'false' ? 'selected' : ''}>Pacientes No Disponibles</option>
                            </select>
                		<input type="submit" name="btnFiltrar" value="Filtrar">
            		</form>
				
				<td class="columnaCentral"><form action="listarPacientes.html" method="GET">
                		<input type="submit" name="btnBuscar" value="Borrar Filtros">
            		</form>
            		</td>
				<td class="columnaLateral"><b>Bienvenido Admin</b></td>
			</tr>
</table>

${mensaje}
<div class="table-responsive">
<table class="tabla">
	<tr> 
		<td>DNI</td> 
		<td>Nombre</td> 
		<td>Apellido</td> 
		<td>Fecha de Nacimiento</td> 
		<td>Direccion</td> 
		<td>Localidad</td> 
		<td>Provincia</td> 
		<td>Correo</td> 
		<td>Telefono</td> 
		<td>Estado</td> 
		<td></td> 
	</tr>
	<c:forEach var="paciente" items="${pacientes}">
		<tr>
			<td>${paciente.DNI}</td>
			<td>${paciente.nombre}</td>
			<td>${paciente.apellido}</td>
			<td>${paciente.telefono}</td>
			<td>${paciente.direccion}</td>
			<td>${paciente.localidad}</td>
			<td>${paciente.provincia}</td>
			<td>${paciente.fechaNac}</td>
			<td>${paciente.correo}</td>
			<td>${paciente.estado ? "Disponible" : "No disponible"}</td>
			<td class="actions">
				<c:choose>
                	<c:when test="${paciente.estado}">
                    	<form action="${pageContext.request.contextPath}/bajaPaciente.html" method="post">
                        	<input type="hidden" name="DNI" value="${paciente.DNI}" />
                            <input type="submit" onclick="return confirm('¿Seguro que desea dar de baja este paciente?');" value="Baja Lógica" />
                        </form>
                    </c:when>
                	<c:otherwise>
                    <form action="${pageContext.request.contextPath}/cambiarAltaPaciente.html" method="post">
                    	<input type="hidden" name="DNI" value="${paciente.DNI}" />
                        <input type="submit" onclick="return confirm('¿Seguro que desea dar de alta este paciente?');" value="Alta Lógica" />
                    </form>
                    </c:otherwise>
                </c:choose>
			</td>
		</tr>
	</c:forEach>
</table>
</div>
			<c:choose>
		<c:when test="${busqueda}">
			<div class="pagination">
                <c:forEach var="i" begin="0" end="${totalPages - 1}">
                    <a href="buscarPacienteDinamico.html?page=${i}&txtNombre=${param.txtNombre}" class="${i == currentPage ? 'active' : ''}">${i + 1}</a>
                </c:forEach>
            </div>
		</c:when>
		<c:when test="${filtro}">
			<div class="pagination">
                <c:forEach var="i" begin="0" end="${totalPages - 1}">
                    <a href="listarPacientesFiltro.html?page=${i}&ddlFiltroEstado=${ddlFiltroEstado}" class="${i == currentPage ? 'active' : ''}">${i + 1}</a>
                </c:forEach>
            </div>
		</c:when>
		<c:otherwise>
			<div class="pagination">
                <c:forEach var="i" begin="0" end="${totalPages - 1}">
                    <a href="listarPacientes.html?page=${i}&ddlFiltroEstado=${ddlFiltroEstado}" class="${i == currentPage ? 'active' : ''}">${i + 1}</a>
                </c:forEach>
            </div>
		</c:otherwise>
	</c:choose>
	</div>

<div class="footer">
        <p>&copy; 2024 Sistema de Gestión Médica</p>
    </div>
</body>
</html>