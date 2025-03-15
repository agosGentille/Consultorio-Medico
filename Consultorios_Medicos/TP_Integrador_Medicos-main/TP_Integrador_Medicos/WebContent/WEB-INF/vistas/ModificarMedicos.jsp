<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Modificar Medicos</title>
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
<h1>Modificar Medicos</h1></div>
<div class="container">
<div class="content">

<form action="${pageContext.request.contextPath}/buscarMedico.html" method="get">
	<table class="tabla">
		<tr>
			<td class="columnaLateral"><b><a href="homeAdmin.html"> Volver a Home </a></b> </td>
			<td class="columnaCentral"></td>
			<td class="columnaCentral"></td>
			<td class="columnaLateral"><a href="inicio.html"><b> Cerrar Sesion</b> </a> </td>
		</tr>
		<tr>
			<td class="columnaLateral"></td>
			<td class="columnaCentral"></td>
			<td class="columnaCentral"></td>
			<td class="columnaLateral"><b>Bienvenido Admin</b></td>
		</tr>
		<tr>
			<td class="columnaLateral"><b>Ingrese el legajo del médico a modificar</b></td>
			<td class="columnaCentral"><input type="text" pattern="\d+" title="Solo se permiten números" required name="txtLegajo"></td>
			<td class="columnaCentral"><input type="submit" value="Buscar" name="btnBuscarMedico"></td>
			<td class="columnaLateral">${estadoAgregarMedico}</td>
		</tr>
	</table>
</form>

<c:if test="${not empty medico}">
	<form action="${pageContext.request.contextPath}/modificarMedico.html" method="post">
		<table class="tabla">
			<tr>
				<td class="columnaLateral"></td>
				<td class="columnaCentral">Nombre:</td>
				<td class="columnaCentral"><input type="text" required name="txtNombre" value="${medico.nombre}"></td>
				<td class="columnaLateral"></td>
			</tr>
			<tr>
				<td class="columnaLateral"></td>
				<td class="columnaCentral">Apellido:</td>
				<td class="columnaCentral"><input type="text" required name="txtApellido" value="${medico.apellido}"></td>
				<td class="columnaLateral"></td>
			</tr>
			<tr>
				<td class="columnaLateral"></td>
				<td class="columnaCentral">Fecha de Nacimiento:</td>
				<td class="columnaCentral"><input type="text" required name="txtFechaNacimiento" value="${medico.fechaNacimiento}"></td>
				<td class="columnaLateral"></td>
			</tr>
			<tr>
				<td class="columnaLateral"></td>
				<td class="columnaCentral">Direccion:</td>
				<td class="columnaCentral"><input type="text" required name="txtDireccion" value="${medico.direccion}"></td>
				<td class="columnaLateral"></td>
			</tr>
			<tr>
				<td class="columnaLateral"></td>
				<td class="columnaCentral">Localidad:</td>
				<td class="columnaCentral"><input type="text" required name="txtLocalidad" value="${medico.localidad}"></td>
				<td class="columnaLateral"></td>
			</tr>
			 
			<tr>
				<td class="columnaLateral"></td>
				<td class="columnaCentral">Sexo:</td>
				<td class="columnaCentral">
					<select name="ddlSexo">
		                <c:set var="sexo" value="${medico.sexo}" />
						<c:set var="sexoString" value="${sexo.toString()}" />
						<option value="M" ${sexoString == 'M' ? 'selected="selected"' : ''}>Masculino</option>
						<option value="F" ${sexoString == 'F' ? 'selected="selected"' : ''}>Femenino</option>
						<option value="O" ${sexoString == 'O' ? 'selected="selected"' : ''}>Otro</option>
		            </select>
				</td>
				<td class="columnaLateral"></td>
			</tr>
			<tr>
				<td class="columnaLateral"></td>
				<td class="columnaCentral">Especialidad:</td>
				<td class="columnaCentral">
					<select name="ddlEspecialidad">
						<c:forEach items="${especialidades}" var="especialidad">
							<option value="${especialidad.id}" ${medico.especialidad.id == especialidad.id ? 'selected' : ''}>${especialidad.nombre}</option>
						</c:forEach>
					</select>
				</td>
				<td class="columnaLateral"></td>
			</tr>
			<tr>
				<td class="columnaLateral"></td>
				<td class="columnaCentral">Telefono:</td>
				<td class="columnaCentral"><input type="text" pattern="\d+" title="Solo se permiten números" required name="txtTelefono" value="${medico.telefono}"></td>
				<td class="columnaLateral"></td>
			</tr>
			
			<tr>
				<td class="columnaLateral"></td>
				<td class="columnaCentral">Email:</td>
				<td class="columnaCentral"><input type="text" required name="txtEmail" value="${medico.email}"></td>
				<td class="columnaLateral"></td>
			</tr>
			
			<tr>
				<td class="columnaLateral"></td>
				<td class="columnaCentral">Dias que trabaja:</td>
				<td class="columnaCentral">
					<c:set var="diasSemana" value="Lunes,Martes,Miercoles,Jueves,Viernes,Sabado,Domingo" />
        			<c:forEach var="diaSemana" items="${diasSemana.split(',')}">
            			<c:set var="isChecked" value="false" />
            			<c:forEach var="diaSeleccionado" items="${diasSeleccionados}">
                			<c:if test="${fn:contains(diaSeleccionado, diaSemana)}">
                    			<c:set var="isChecked" value="true" />
                			</c:if>
            			</c:forEach>
            			<input type="checkbox" name="chkdiasTrabajo" value="${diaSemana}" <c:if test="${isChecked eq 'true'}">checked</c:if>> ${diaSemana}<br>
        			</c:forEach>
        		</td>
				<td class="columnaLateral"></td>
			</tr>
			<tr>
				<td class="columnaLateral"></td>
				<td class="columnaCentral">Hora Entrada:</td>
				<td class="columnaCentral">
					<input type="text" size="2" name="txtHoraEnt" pattern="\d+" title="Solo se permiten números" required placeholder="HH" value="${horaEntr}">:
                    <input type="text" size="2" name="txtMinutoEnt" pattern="\d+" title="Solo se permiten números" required placeholder="MM" value="${minEntr}">
                </td>
				<td class="columnaLateral"></td>
			</tr>
			<tr>
				<td class="columnaLateral"></td>
				<td class="columnaCentral">Hora Salida:</td>
				<td class="columnaCentral">
					<input type="text" size="2" pattern="\d+" required name="txtHoraSal" placeholder="HH" value="${horaSal}">:
                    <input type="text" size="2" pattern="\d+" required name="txtMinutoSal" placeholder="MM" value="${minEntr}">
                </td>
				<td class="columnaLateral"></td>
			</tr>
			<tr>
				<td class="columnaLateral"></td>
				<td class="columnaCentral">Estado:</td>
				<td class="columnaCentral">
					<select name="ddlEstado">
						<option value="true" ${medico.estado ? 'selected' : ''}>Disponible</option>
						<option value="false" ${!medico.estado ? 'selected' : ''}>No disponible</option>
					</select>
				</td>
				<td class="columnaLateral"></td>
			</tr>
			<tr>
				<td class="columnaLateral"></td>
				<td class="columnaCentral">Nombre de usuario:</td>
				<td class="columnaCentral"><input type="text" name="txtUsuario" required value="${usuario.getNombre_usuario()}"></td>
				<td class="columnaLateral"></td>
			</tr>
			<tr>
				<td class="columnaLateral"></td>
				<td class="columnaCentral">Contraseña:</td>
				<td class="columnaCentral"><input type="password" required id="password" name="txtContra" value="${usuario.getContrasenia()}"/> 
					<input type="checkbox" id="mostrarContra" onclick="mostrarContraseña()">Mostrar</td>
				<td class="columnaLateral"></td>
				<script>
			        function mostrarContraseña() {
			            var passwordField = document.getElementById("password");
			            var checkbox = document.getElementById("mostrarContra");
			            if (checkbox.checked) {
			                passwordField.type = "text";
			            } else {
			                passwordField.type = "password";
			            }
			        }
    			</script>
			</tr>
			
			<tr>
				<td class="columnaLateral"></td>
				<td class="columnaCentral"></td>
				<td class="columnaCentral">
					<input type="hidden" name="legajo" value="${medico.legajo}" />
					<input type="submit" value="Guardar" onclick="return confirm('¿Seguro que desea modificar este medico?');" name="btnModificarMedico">
				</td>
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
