<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Asignar Turnos</title>
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
        .tabla {
            width: 100%;
            margin-top: 20px;
        }
        .columnaLateral {
            width: 25%;
        }
        .columnaCentral {
            width: 25%;
        }
    </style>
    <script>
        function submitForm() {
            document.getElementById('especialidadForm').submit();
        }
        // Función para actualizar inputs hidden con los valores del segundo formulario
        function updateHiddenInputs() {
            // Obtener valores del segundo formulario
            var ddlPacienteValue = document.getElementById('ddlPaciente').value;
            var ddlMedicoValue = document.getElementById('ddlMedico').value;
            var txtDiaValue = document.getElementById('txtDia').value;
            var txtMesValue = document.getElementById('txtMes').value;
            var txtAnioValue = document.getElementById('txtAnio').value;
            var txtHoraValue = document.getElementById('txtHora').value;
            var txtMinutoValue = document.getElementById('txtMinuto').value;

            // Actualizar inputs hidden del primer formulario
            document.getElementById('hiddenDdlPaciente').value = ddlPacienteValue;
            document.getElementById('hiddenDdlMedico').value = ddlMedicoValue;
            document.getElementById('hiddenTxtDia').value = txtDiaValue;
            document.getElementById('hiddenTxtMes').value = txtMesValue;
            document.getElementById('hiddenTxtAnio').value = txtAnioValue;
            document.getElementById('hiddenTxtHora').value = txtHoraValue;
            document.getElementById('hiddenTxtMinuto').value = txtMinutoValue;
        }
    </script>
</head>
<body>
<div class="header">
<h1>Asignar Turnos</h1>
</div>
<div class="container">
    <table class="tabla">
        <tr>
            <td class="columnaLateral"><b><a href="homeAdmin.html"> Volver a Home </a></b></td>
            <td class="columnaCentral"></td>
            <td class="columnaCentral"></td>
            <td class="columnaLateral"><b><a href="inicio.html"> Cerrar Sesion </a></b></td>
        </tr>
        <tr>
            <td class="columnaLateral"></td>
            <td class="columnaCentral"></td>
            <td class="columnaCentral"></td>
            <td class="columnaLateral"><b>Bienvenido Admin</b></td>
        </tr>
        <tr>
            <td class="columnaLateral"></td>
            <td class="columnaCentral"></td>
            <td class="columnaCentral"></td>
            <td class="columnaLateral">  </td>
        </tr>
    </table>

    <!-- Formulario para seleccionar especialidad -->
    <form id="especialidadForm" action="${pageContext.request.contextPath}/listarMedicosAsignarTurnos.html" method="post">
        <table class="tabla">
            <tr>
                <td class="columnaLateral"></td>
                <td class="columnaCentral">Especialidad:</td>
                <td class="columnaCentral">
                    <select name="ddlEspecialidad" onchange="submitForm()">
                        <option value="">Seleccione una especialidad</option>
                        <c:forEach items="${especialidades}" var="especialidad">
                            <option value="${especialidad.id}"
                                    <c:if test="${especialidad.id eq ddlEspecialidadSeleccionada}">selected</c:if>>
                                ${especialidad.id} - ${especialidad.nombre}
                            </option>
                        </c:forEach>
                    </select>
                </td>
                <td class="columnaLateral"></td>
            </tr>
            <tr>
            <td>
	            <!-- Inputs ocultos para mantener la selección del segundo formulario -->
	            <input type="hidden" id="hiddenDdlPaciente" name="HddlPaciente" value="${not empty ddlPacienteSeleccionado ? ddlPacienteSeleccionado : ''}">
	            <input type="hidden" id="hiddenDdlMedico" name="HddlMedico" value="${not empty ddlMedicoSeleccionado ? ddlMedicoSeleccionado : ''}">
	            <input type="hidden" id="hiddenTxtDia" name="HtxtDia" value="${not empty txtDia ? txtDia : ''}">
	            <input type="hidden" id="hiddenTxtMes" name="HtxtMes" value="${not empty txtMes ? txtMes : ''}">
	            <input type="hidden" id="hiddenTxtAnio" name="HtxtAnio" value="${not empty txtAnio ? txtAnio : ''}">
	            <input type="hidden" id="hiddenTxtHora" name="HtxtHora" value="${not empty txtHora ? txtHora : ''}">
	            <input type="hidden" id="hiddenTxtMinuto" name="HtxtMinuto" value="${not empty txtMinuto ? txtMinuto : ''}">
        	</td>
            </tr>
        </table>
    </form>

    <!-- Formulario para crear turno -->
    <form id="crearTurnoForm" action="${pageContext.request.contextPath}/crearTurno.html" method="post" onsubmit="updateHiddenInputs()">
        <table class="tabla">
            <tr>
                <td class="columnaLateral"></td>
                <td class="columnaCentral">Paciente:</td>
                <td class="columnaCentral">
                    <select id="ddlPaciente" name="ddlPaciente" onchange="updateHiddenInputs()">
                        <c:forEach items="${pacientes}" var="paciente">
                            <option value="${paciente.DNI}"
                                    <c:if test="${paciente.DNI eq ddlPacienteSeleccionado}">selected</c:if>>
                                ${paciente.DNI} - ${paciente.nombre} ${paciente.apellido}
                            </option>
                        </c:forEach>
                    </select>
                </td>
                <td class="columnaLateral"></td>
            </tr>
            <tr>
                <td class="columnaLateral"></td>
                <td class="columnaCentral">Médico:</td>
                <td class="columnaCentral">
                    <select id="ddlMedico" name="ddlMedico">
                        <c:forEach items="${medicos}" var="medico">
                            <option value="${medico.legajo}">${medico.legajo} - ${medico.nombre} ${medico.apellido}</option>
                        </c:forEach>
                    </select>
                </td>
                <td class="columnaLateral"></td>
            </tr>
            <tr>
                <td class="columnaLateral"></td>
                <td class="columnaCentral">Fecha:</td>
                <td class="columnaCentral">
                    <input type="text" pattern="\d+" id="txtDia" size="2" pattern="\d+" title="Solo se permiten números" required name="txtDia" placeholder="DD" value="${not empty txtDia ? txtDia : ''}" onkeyup="updateHiddenInputs()">/
                    <input type="text" pattern="\d+" id="txtMes" size="2" pattern="\d+" title="Solo se permiten números" required name="txtMes" placeholder="MM" value="${not empty txtMes ? txtMes : ''}" onkeyup="updateHiddenInputs()">/
                    <input type="text" pattern="\d+" id="txtAnio" size="4" pattern="\d+" title="Solo se permiten números" required name="txtAnio" placeholder="AAAA" value="${not empty txtAnio ? txtAnio : ''}" onkeyup="updateHiddenInputs()">
                </td>
                <td class="columnaLateral"></td>
            </tr>
            <tr>
                <td class="columnaLateral"></td>
                <td class="columnaCentral">Horario:</td>
                <td class="columnaCentral">
                    <input type="text" pattern="\d+" id="txtHora" size="2" pattern="\d+" title="Solo se permiten números" required name="txtHora" placeholder="HH" value="${not empty txtHora ? txtHora : ''}" onkeyup="updateHiddenInputs()">:
                    <input type="text" pattern="\d+" id="txtMinuto" size="2" pattern="\d+" title="Solo se permiten números" required name="txtMinuto" placeholder="MM" value="${not empty txtMinuto ? txtMinuto : ''}" onkeyup="updateHiddenInputs()">
                </td>
                <td class="columnaLateral"></td>
            </tr>
            <tr>
                <td class="columnaLateral"></td>
                <td class="columnaCentral"></td>
                <td class="columnaCentral"><input type="submit" onclick="return confirm('¿Seguro que desea asignar este turno?');" value="Asignar Turno" name="btnAsignarTurno"></td>
                <td class="columnaLateral">${mensaje}</td>
            </tr>
            <tr>
                <td class="columnaLateral"><br><br>*Para seleccionar un médico, primero debe seleccionar una especialidad</td>
                <td class="columnaCentral"></td>
                <td class="columnaCentral"></td>
                <td class="columnaLateral"></td>
            </tr>
        </table>
    </form>
    </div>
    <div class="footer">
        <p>&copy; 2024 Sistema de Gestión Médica</p>
    </div>
</body>
</html>