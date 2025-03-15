<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ver Turnos / Medico</title>
<style type="text/css">	
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
	</style>
</head>
<body>
<div class="header">
<h1>Cargar Presentismo y Observaciones</h1>
</div>
<div class="container">
<div class="content">
<table class="listado">
	<tr> 
		<td colspan="3" style="text-align: center;">Turno</td> 
		<td colspan="4" style="text-align: center;">Datos del Paciente</td>
		<td colspan="3" style="text-align: center;">Profesional</td> 
		<td rowspan="2">Especialidad</td> 
		<td rowspan="2">Observaciones</td> 
		<td rowspan="2">Estado</td>
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
            
			
		</tr>
</table>

<form action="agregarObs.html" method="post">
	<table class="visible">
		<tr>
			<td> Estado: </td>
			<td> <input type="radio" name="radioEstado" required value="Presente"> Presente</td>
			<td> </td>
			<td> </td>
		</tr>
		<tr>
			<td> </td>
			<td> <input type="radio" name="radioEstado" required value="Ausente"> Ausente</td>
			<td> </td>
			<td> </td>
		</tr>
		<tr>
			<td> Observaciones: </td>
			<td> <textarea class="txtObs" name="txtObservaciones" placeholder="Escribe las observaciones aquí..."></textarea></td>
			<td> </td>
			<td> </td>
		</tr>
		<tr>
			<td> </td>
			<td> <input type="submit" name="btnAgregarObs" value="Agregar"></td>
			<td> </td>
			<td> </td>
		</tr>
	</table>
</form>
</div>
</div>
<div class="footer">
        <p>&copy; 2024 Sistema de Gestión Médica</p>
    </div>

</body>
</html>