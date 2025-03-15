<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vista Pacientes</title>
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
	</style>
</head>
<body>
<div class="header">
<h1>Modificar Paciente</h1></div>
<div class="container">
<div class="content">
			<form action="${pageContext.request.contextPath}/buscarPaciente.html" method="get">

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
			<tr>
				<td class="columnaLateral">  </td>
				<td class="columnaCentral"></td>
				<td class="columnaCentral"></td>
				<td class="columnaLateral">  </td>
			</tr>
			<tr>
				<td class="columnaLateral"></td>
				<td class="columnaCentral">Ingrese el DNI:</td>
				<td class="columnaCentral"><input type= "text" pattern="\d+" title="Solo se permiten números" required name="txtDni"></td>
				<td class="columnaLateral"><input type="submit" value="Buscar" name="btnBuscarPac">${estadoModificarPaciente}</td>
			</tr>
	</form>
</table>
			
		<c:if test="${not empty paciente}">
		
			<form action="${pageContext.request.contextPath}/modificarPaciente.html" method="post">
			
			<table class="tabla">
			<tr>
				<td class="columnaLateral"><b>Modifique los Datos del Paciente</b></td>
				<td class="columnaCentral"></td>
				<td class="columnaCentral"></td>
				<td class="columnaLateral"></td>
			</tr>
			<tr>
				<td class="columnaLateral"></td>
				<td class="columnaCentral">Nombre:</td>
				<td class="columnaCentral"><input type= "text" required name="txtNombre" value="${paciente.nombre}"></td>
				<td class="columnaLateral"></td>
			</tr>
			<tr>
				<td class="columnaLateral"></td>
				<td class="columnaCentral">Apellido:</td>
				<td class="columnaCentral"><input type= "text" required name="txtApellido" value="${paciente.apellido}"></td>
				<td class="columnaLateral"></td>
			</tr>
			<tr>
				<td class="columnaLateral"></td>
				<td class="columnaCentral">Fecha de Nacimiento:</td>
				<td class="columnaCentral"><input type="text" required name="txtFecha" value="${paciente.fechaNac}"></td>
				<td class="columnaLateral"></td>
			</tr>
			<tr>
				<td class="columnaLateral"></td>
				<td class="columnaCentral">Direccion:</td>
				<td class="columnaCentral"><input type= "text" required name="txtDireccion" value="${paciente.direccion}"></td>
				<td class="columnaLateral"></td>
			</tr>
			<tr>
				<td class="columnaLateral"></td>
				<td class="columnaCentral">Localidad:</td>
				<td class="columnaCentral"><input type= "text" required name="txtLocalidad" value="${paciente.localidad}"></td>
				<td class="columnaLateral"></td>
			</tr>
			<tr>
				<td class="columnaLateral"></td>
				<td class="columnaCentral">Provincia:</td>
				<td class="columnaCentral"><input type= "text" required name="txtProvincia" value="${paciente.provincia}"></td>
				<td class="columnaLateral"></td>
			</tr>
			<tr>
				<td class="columnaLateral"></td>
				<td class="columnaCentral">Correo Electronico:</td>
				<td class="columnaCentral"><input type= "text" required name="txtEmail" value="${paciente.correo}"></td>
				<td class="columnaLateral"></td>
			</tr>
			<tr>
				<td class="columnaLateral"></td>
				<td class="columnaCentral">Telefono:</td>
				<td class="columnaCentral"><input type= "text" required pattern="\d+" title="Solo se permiten números" name="txtTelefono" value="${paciente.telefono}"></td>
				<td class="columnaLateral"></td>
			</tr>
			<tr>
				<td class="columnaLateral"></td>
				<td class="columnaCentral">Estado:</td>
				<td class="columnaCentral">
					<select name="ddlEstado">
						<option value="true" ${paciente.estado ? 'selected' : ''}>Disponible</option>
						<option value="false" ${!paciente.estado ? 'selected' : ''}>No disponible</option>
					</select>
				</td>
				<td class="columnaLateral"></td>
			</tr>		
			<tr>
				<td class="columnaLateral"></td>
				<td class="columnaCentral"></td>
				<td class="columnaCentral"><input type="hidden" name="DNI" value="${paciente.DNI}" />
				<input type="submit" value="Guardar" onclick="return confirm('¿Seguro que desea modificar este paciente?');" name="btnGuardarPac"></td>
				<td class="columnaLateral"></td>
			</tr>
		</table>
		
	</form>
		
</c:if>
</div>
</div>
	<div class="footer">
        <p>&copy; 2024 Sistema de Gestión Médica</p>
    </div>	
			
	</body>
</html>