<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Vista Pacientes</title>
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
<h1>Alta Pacientes</h1>
</div>

<div class="container">
<div class="content">
    <table>
        <tr>
            <td class="columnaLateral"><b><a href="homeAdmin.html">Volver a Home</a></b></td>
            <td class="columnaCentral"></td>
            <td class="columnaCentral"></td>
            <td class="columnaLateral"><a href="inicio.html"><b>Cerrar Sesión</b></a></td>
        </tr>
        <tr>
            <td class="columnaLateral"></td>
            <td class="columnaCentral"></td>
            <td class="columnaCentral"></td>
            <td class="columnaLateral"><b>Bienvenido Admin</b></td>
        </tr>
    </table>
    <form action="${pageContext.request.contextPath}/agregarPaciente.html" method="post">
        <table class="tabla">
            <tr>
                <td class="columnaLateral"><b>Ingrese los Datos del Paciente</b></td>
                <td class="columnaCentral"></td>
                <td class="columnaCentral"></td>
                <td class="columnaLateral"></td>
            </tr>
            <tr>
                <td class="columnaLateral"></td>
                <td class="columnaCentral">DNI:</td>
                <td class="columnaCentral"><input type="text" name="txtDni" pattern="\d+"></td>
                <td class="columnaLateral"></td>
            </tr>
            <tr>
                <td class="columnaLateral"></td>
                <td class="columnaCentral">Nombre:</td>
                <td class="columnaCentral"><input type="text" name="txtNombre"></td>
                <td class="columnaLateral"></td>
            </tr>
            <tr>
                <td class="columnaLateral"></td>
                <td class="columnaCentral">Apellido:</td>
                <td class="columnaCentral"><input type="text" name="txtApellido"></td>
                <td class="columnaLateral"></td>
            </tr>
            <tr>
                <td class="columnaLateral"></td>
                <td class="columnaCentral">Fecha de Nacimiento:</td>
                <td class="columnaCentral"><input type="text" name="txtFechaNacimiento"></td>
                <td class="columnaLateral"></td>
            </tr>
            <tr>
                <td class="columnaLateral"></td>
                <td class="columnaCentral">Dirección:</td>
                <td class="columnaCentral"><input type="text" name="txtDireccion"></td>
                <td class="columnaLateral"></td>
            </tr>
            <tr>
                <td class="columnaLateral"></td>
                <td class="columnaCentral">Localidad:</td>
                <td class="columnaCentral"><input type="text" name="txtLocalidad"></td>
                <td class="columnaLateral"></td>
            </tr>
            <tr>
                <td class="columnaLateral"></td>
                <td class="columnaCentral">Provincia:</td>
                <td class="columnaCentral"><input type="text" name="txtProvincia"></td>
                <td class="columnaLateral"></td>
            </tr>
            <tr>
                <td class="columnaLateral"></td>
                <td class="columnaCentral">Correo Electrónico:</td>
                <td class="columnaCentral"><input type="text" name="txtCorreo"></td>
                <td class="columnaLateral"></td>
            </tr>
            <tr>
                <td class="columnaLateral"></td>
                <td class="columnaCentral">Teléfono:</td>
                <td class="columnaCentral"><input type="text" name="txtTelefono" pattern="\d+"></td>
                <td class="columnaLateral"></td>
            </tr>        
            <tr>
                <td class="columnaLateral"></td>
                <td class="columnaCentral"></td>
                <td class="columnaCentral"><input type="submit" value="Guardar" name="btnGuardarPac"></td>
                <td class="columnaLateral"></td>
                <td>${estadoAgregarPaciente}</td>
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
