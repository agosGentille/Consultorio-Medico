<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Administrador</title>
<style type="text/css">
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
        max-width: 600px;
    }
    .header {
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin-bottom: 20px;
    }
    .header b {
        font-size: 20px;
    }
    .header a {
        color: #007BFF;
        text-decoration: none;
    }
    .header a:hover {
        text-decoration: underline;
    }
    .menu {
        list-style-type: none;
        padding: 0;
        margin: 0;
    }
    .menu li {
        margin: 10px 0;
    }
    .menu a {
        color: #007BFF;
        text-decoration: none;
        font-size: 16px;
    }
    .menu a:hover {
        text-decoration: underline;
    }
    .note {
        text-align: right;
        font-size: 12px;
        color: #888;
    }
</style>
</head>
<body>
    <div class="container">
        <div class="header">
            <b>Bienvenido Admin</b>
            <a href="inicio.html">Cerrar Sesión</a>
        </div>
        <div class="note">(vuelve a Login al cerrar sesión)</div>
        <ul class="menu">
            <li><a href="altaMedico.html">Alta Medico</a></li>
            <li><a href="modificarMedicos.html">Modificar Medicos</a></li>
            <li><a href="listarMedicos.html">Baja y listado de Medicos</a></li>
            <li><a href="altaPaciente.html">Alta Paciente</a></li>
            <li><a href="modificarPacientes.html">Modificar Pacientes</a></li>
            <li><a href="listarPacientes.html">Baja y listado de Pacientes</a></li>
            <li><a href="asignarTurnos.html">Asignar Turnos</a></li>
            <li><a href="informes.html">Informes</a></li>
			<li><a href="bajaListaEspecialidad.html">Baja y listado de Especialidades</a></li>
        </ul>
    </div>
</body>
</html>