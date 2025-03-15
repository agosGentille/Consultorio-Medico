<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Alta Médicos</title>
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
            width: 80%;
            margin: auto;
            overflow: hidden;
        }
        .content {
            background-color: white;
            padding: 20px;
            margin-top: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        table {
            width: 100%;
            border-collapse: collapse;
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
        input[type="text"], input[type="password"], select {
            width: calc(100% - 22px);
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #28a745;
            border: none;
            border-radius: 5px;
            color: white;
            font-size: 16px;
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
    </style>
</head>
<body>
    <div class="header">
        <h1>Alta Médicos</h1>
    </div>
    <div class="container">
        <div class="content">
            <form action="${pageContext.request.contextPath}/agregarMedico.html" method="post">
                <table>
                    <tr>
                        <th colspan="3"><b>Bienvenido a Alta Médico</b></th>
                    </tr>
                    <tr>
                        <td colspan="3"><a href="homeAdmin.html"><b>Volver a Home</b></a></td>
                    </tr>
                    <tr>
                        <td colspan="3"><b>Ingrese los datos del médico:</b></td>
                    </tr>
                    <tr>
                        <td>Nombre:</td>
                        <td><input required type="text" name="txtNombre" /></td>
                    </tr>
                    <tr>
                        <td>Apellido:</td>
                        <td><input required type="text" name="txtApellido" /></td>
                    </tr>
                    <tr>
                        <td>Fecha de Nacimiento:</td>
                        <td><input required type="date" name="txtFechaNacimiento" /></td>
                    </tr>
                    <tr>
                        <td>Dirección:</td>
                        <td><input required type="text" name="txtDireccion" /></td>
                    </tr>
                    <tr>
                        <td>Localidad:</td>
                        <td><input required type="text" name="txtLocalidad" /></td>
                    </tr>
                    <tr>
                        <td>Sexo:</td>
                        <td>
                            <select name="ddlSexo">
                                <option value="M">Masculino</option>
                                <option value="F">Femenino</option>
                                <option value="O">Otro</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Especialidad:</td>
                        <td>
                            <select name="ddlEspecialidad">
                                <c:forEach items="${especialidades}" var="especialidad">
                                    <option value="${especialidad.id}">${especialidad.nombre}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Teléfono (sin caracteres especiales ni espacios):</td>
                        <td><input required type="text" name="txtTelefono" pattern="\d+" title="Solo se permiten numeros" /></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><input required type="text" name="txtEmail" /></td>
                    </tr>
                    <tr>
                        <td>Días Laborales:</td>
                        <td>
                            <input type="checkbox" name="chkdiasTrabajo" value="Lunes"> Lunes<br>
                            <input type="checkbox" name="chkdiasTrabajo" value="Martes"> Martes<br>
                            <input type="checkbox" name="chkdiasTrabajo" value="Miercoles"> Miércoles<br>
                            <input type="checkbox" name="chkdiasTrabajo" value="Jueves"> Jueves<br>
                            <input type="checkbox" name="chkdiasTrabajo" value="Viernes"> Viernes<br>
                            <input type="checkbox" name="chkdiasTrabajo" value="Sabado"> Sábado<br>
                            <input type="checkbox" name="chkdiasTrabajo" value="Domingo"> Domingo<br>
                        </td>
                    </tr>
                    <tr>
                        <td>Hora Entrada:</td>
                        <td class="inline-inputs">
                            <input type="text" size="2" pattern="\d+" title="Solo se permiten números" required name="txtHoraEnt" placeholder="HH">
                            :
                            <input type="text" size="2" pattern="\d+" title="Solo se permiten números" required name="txtMinutoEnt" placeholder="MM">
                        </td>
                    </tr>
                    <tr>
                        <td>Hora Salida:</td>
                        <td class="inline-inputs">
                            <input type="text" size="2" pattern="\d+" title="Solo se permiten números" required name="txtHoraSal" placeholder="HH">
                            :
                            <input type="text" size="2" pattern="\d+" title="Solo se permiten números" required name="txtMinutoSal" placeholder="MM">
                        </td>
                    </tr>
                    <tr>
                        <td>Estado:</td>
                        <td>
                            <select name="ddlEstado">
                                <option value="true">Disponible</option>
                                <option value="false">No disponible</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><br><b>Datos de Usuario:</b></td>
                    </tr>
                    <tr>
                        <td>Usuario:</td>
                        <td><input type="text" required name="txtUsuario"></td>
                    </tr>
                    <tr>
                        <td>Contraseña:</td>
                        <td><input type="password" required id="password" name="txtContra" /> 
                            <input type="checkbox" id="mostrarContra" onclick="mostrarContraseña()">Mostrar
                        </td>
                    </tr>
                    <tr>
                        <td>Repetir Contraseña:</td>
                        <td><input type="password" required id="passwordX2" name="txtContraX2" /> 
                            <input type="checkbox" id="mostrarContraX2" onclick="mostrarContraseñaX2()">Mostrar
                        </td>
                    </tr>
                    <tr>
                        <td> 
                            <input type="submit" onclick="return confirm('¿Seguro que desea agregar este medico?');" value="Guardar" />
                        </td>
                        <td>${estadoAgregarMedico}</td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <div class="footer">
        <p>&copy; 2024 Sistema de Gestión Médica</p>
    </div>
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
        function mostrarContraseñaX2() {
            var passwordField = document.getElementById("passwordX2");
            var checkbox = document.getElementById("mostrarContraX2");
            if (checkbox.checked) {
                passwordField.type = "text";
            } else {
                passwordField.type = "password";
            }
        }
    </script>
</body>
</html>
