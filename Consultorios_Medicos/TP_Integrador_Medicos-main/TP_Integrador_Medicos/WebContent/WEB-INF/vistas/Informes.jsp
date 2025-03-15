<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	
	<title>Informes</title>
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
	        .dateLabel {
			  display: block;
			  font:
			    1rem 'Fira Sans',
			    sans-serif;
			}
			input,
			dateLabel {
			  margin: 0.4rem 0;
			}
			
			body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
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
        
	</style>
</head>

<body>
	<div class="container">
	<table class="tabla">
				<tr>
					<td class="columnaLateral"><b><a href="homeAdmin.html"> Volver a Home </a></b> </td>
					<td class="columnaCentral"></td>
					<td class="columnaCentral"></td>
					<td class="columnaLateral"><b><a href="inicio.html"> Cerrar Sesion </a> </td>
				</tr>
				<tr>
					<td class="columnaLateral"></td>
					<td class="columnaCentral"></td>
					<td class="columnaCentral"></td>
					<td class="columnaLateral"><b>Bienvenido Admin</b></td>
				</tr>
	</table>
	<br>
	<table class="tabla">
		<form id="commentForm" action="buscarMedicoPorLegajo.html" method="GET">
				<tr>
					<td class="columnaLateral">  <b>Informes</b></td>
					<td class="columnaCentral"></td>
					<td class="columnaCentral"></td>
					<td class="columnaLateral">  </td>
				</tr>
				<tr>
					<td class="columnaLateral"></td>
					<td class="columnaCentral">Ingrese el legajo del medico:</td>
					<td class="columnaCentral"><input type= "number" name="intLegajo" required  min=1 max=9999></td>
					<td class="columnaLateral"></td>
				</tr>
				<tr>
					<td class="columnaLateral"></td>
					<td class="columnaCentral">Ingrese lapso de fechas a buscar:</td>
					<td class="columnaCentral">
					<input class="dateLabel" type="date" id="startDate" name="startDate" value="2025-01-01" min="1900-01-01" max="2030-07-30" required>
					<input class="dateLabel" type="date" id="endDate" name="endDate" value="2025-03-01" min="1900-01-01" max="2030-07-30" required>
					<td class="columnaLateral"></td>
				</tr>
				<tr>
					<td class="columnaLateral"><b>Buscar turnos del medico en fechas ingresadas</b> </td>
					<td class="columnaCentral"></td>
					<div class="button-container">
					<td class="columnaCentral"><input class="btn" id="btnTurnos" type="submit" value="Buscar" name="btnTurnos"></td>
					</div>
					<td class="columnaLateral"></td>
				</tr>
			</form>
	</table>
	
	<script>
		$("commentForm").validate();
	</script>
	
	<br>
	${mensaje}
	<br><br>
	<table class="tabla">
			<tr>
				<th>Id Turno</th>
				<th>Estado</th>
				<th>Fecha</th>
				<th>Hora</th>
				<th>Observaciones</th>
				<th>Dni Paciente</th>
				<th>Nombre Paciente</th>
			</tr>
		<c:forEach var="turno" items="${turnos}">
			<tr>
				<td>${turno.id}</td>
				<td>${turno.estadoTurno}</td>
				<td>${turno.fecha}</td>
				<td>${turno.hora}</td>
				<td>${turno.observaciones}</td>
				<td>${turno.paciente.DNI}</td>
				<td>${turno.paciente.apellido}, ${turno.paciente.nombre}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	${mensaje2}
	<br>
	</div>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" ></script>	
	<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.js"></script>	
	<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/additional-methods.min.js"></script>
	<script src='datepicker-es.js' type='text/javascript'></script><link rel="preconnect" href="https://fonts.googleapis.com">
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script>
		$(document).ready(function(){
			$('commentForm').validate();
			$('#btnTurnos').on('click',function(){
				console.log($('commentForm').valid());
			});
		});
	</script>
	
</body>

</html>