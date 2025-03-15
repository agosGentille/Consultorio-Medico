<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ver Turnos / Medico</title>
<style type="text/css">	
	        .tabla {
	            width: 100%;
	        }
	        .columnaLateral {
	            width: 25%;
	        }
	        .columnaCentral {
	            width: 25%;
	        }
	        .listado th, .listado td {
				border: 1px solid black;
				padding: 8px;
				text-align: left;
			}
			.agregarObs th, .agregarObs td {
				border: 1px solid white;
				padding: 8px;
				text-align: left;
			}
			.txtObs {
	            width: 150%;
	            height: 100px;
	            
	            resize: none;
	        }
	        .oculto {
            	display: none;
            	border: 1px solid white;
        	}
       		.visible {
       			border: 1px solid white;
       	     	display: table; /* O `block`, dependiendo de cómo desees mostrarla */
       		}
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
<h1>Detalle de Turnos</h1>
</div>


<div class="container">
<div class="content">
<table class="tabla">
			<tr>
				<td class="columnaLateral"><b><a href="homeUsuario.html"> Volver a Home </a></b> </td>
				<td class="columnaCentral"></td>
				<td class="columnaCentral"></td>
				<td class="columnaLateral"><a href="inicio.html"><b> Cerrar Sesion</b> </a> </td>
			</tr>
			<tr>
				<td class="columnaLateral">
					<form action="buscarTurno.html" method="GET">
                		Buscar Turno: 
                		<input type="text" placeholder="Ingrese el número de turno..." pattern="\d+" title="Solo se permiten números" required name="txtIdTurno" style="width: 188px;">
                		<input type="submit" name="btnBuscar" value="Buscar">
            		</form>
            </td>
				<td class="columnaCentral">
					<form action="verTurnos.html" method="GET">
                		<input type="submit" name="btnBuscar" value="Borrar Filtros">
            		</form>
            		</td>
				<td class="columnaCentral"> </td>
				<td class="columnaLateral"><b>Bienvenido ${Usuario.nombre_usuario}</b></td>
			</tr>
			<tr>
				<td class="columnaLateral"> </td>
				<td class="columnaCentral"></td>
				<td class="columnaCentral"></td>
				<td class="columnaLateral">  </td>
			
			</tr>
</table>
${mensaje}<br>
<div class="table-responsive">
<table class="listado">
	<tr> 
		<td colspan="3" style="text-align: center;">Turno</td> 
		<td colspan="4" style="text-align: center;">Datos del Paciente</td>
		<td colspan="3" style="text-align: center;">Profesional</td> 
		<td rowspan="2">Especialidad</td> 
		<td rowspan="2">Observaciones</td> 
		<td rowspan="2">Estado</td>
		<td rowspan="2"></td>  
	</tr>
	<tr> 
		<td>Nro.</td> 
		<td>Fecha</td> 
		<td>Hora</td> 
		<td>DNI</td>
		<td>Nombre</td>
		<td>Apellido</td>
		<td>Fecha de Nacimiento</td>  
		<td>Legajo</td> 
		<td>Nombre</td> 
		<td>Apellido</td> 
		 
	</tr>
	<c:choose>
	<c:when test="${not empty turnos}">
			<c:forEach var="turno" items="${turnos}">
				<tr>
					<td>${turno.id}</td>
					<td>${turno.fecha}</td>
					<td>${turno.hora}</td>
		            <td>${turno.paciente.DNI}</td>
		            <td>${turno.paciente.nombre}</td>
		            <td>${turno.paciente.apellido}</td>
		            <td>${turno.paciente.fechaNac}</td>
		            <td>${turno.medico.legajo}</td>
		            <td>${turno.medico.nombre}</td>
		            <td>${turno.medico.apellido}</td>
		            <td>${turno.medico.especialidad.nombre}</td>
		            <td>${turno.observaciones}</td>
		            <td>${turno.estadoTurno}</td>
		            <td>
		            	<c:if test="${turno.estadoTurno == 'Pendiente'}">
			                <form action="${pageContext.request.contextPath}/cargarPresentismo.html" method="post">
			                    <input type="hidden" name="idTurno" value="${turno.id}" />
			                    <input type="submit" name="btnCambiarEstado" value="Agregar Observaciones">
			                </form>
		            	</c:if>
		            </td>
					
				</tr>
			</c:forEach>
		</c:when>
		
		<c:when test="${not empty turno}">
			<tr>
					<td>${turno.id}</td>
					<td>${turno.fecha}</td>
					<td>${turno.hora}</td>
		            <td>${turno.paciente.DNI}</td>
		            <td>${turno.paciente.nombre}</td>
		            <td>${turno.paciente.apellido}</td>
		            <td>${turno.paciente.fechaNac}</td>
		            <td>${turno.medico.legajo}</td>
		            <td>${turno.medico.nombre}</td>
		            <td>${turno.medico.apellido}</td>
		            <td>${turno.medico.especialidad.nombre}</td>
		            <td>${turno.observaciones}</td>
		            <td>${turno.estadoTurno}</td>
		            <td>
		            	<c:if test="${turno.estadoTurno == 'Pendiente'}">
			                <form action="${pageContext.request.contextPath}/cargarPresentismo.html" method="post">
			                    <input type="hidden" name="idTurno" value="${turno.id}" />
			                    <input type="submit" name="btnCambiarEstado" value="Agregar Observaciones">
			                </form>
		            	</c:if>
		            </td>
					
				</tr>
		</c:when>
		<c:otherwise>
            
            <tr>
                <td colspan="7">No se encontraron turnos que coincidan con la búsqueda</td>
            </tr>
        </c:otherwise>
		</c:choose>
</table>

			<div class="pagination">
			<c:if test="${totalPages > 0 }">
                <c:forEach var="i" begin="0" end="${totalPages - 1}">
                    <a href="verTurnos.html?page=${i}" class="${i == currentPage ? 'active' : ''}">${i + 1}</a>
                </c:forEach>
            </c:if>
            </div>
</div>
</div>


</div>
<div class="footer">
        <p>&copy; 2024 Sistema de Gestión Médica</p>
    </div>
</body>
</html>