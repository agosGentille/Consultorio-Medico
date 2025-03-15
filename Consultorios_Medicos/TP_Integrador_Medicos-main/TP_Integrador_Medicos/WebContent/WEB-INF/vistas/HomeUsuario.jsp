<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Usuario</title>
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
        .tabla {
            width: 100%;
        }
        .columnaLateral {
            width: 25%;
        }
        .columnaCentral {
            width: 25%;
        }
        .calendar {
            margin-top: 20px;
            border-collapse: collapse;
            width: 100%;
        }
        .calendar th {
            border: 1px solid black;
            padding: 5px;
            text-align: center;
            vertical-align: top;
        }
        .calendar td {
            border: 1px solid black;
            padding: 8px;
            text-align: center;
            vertical-align: top;
            position: relative;
            width: 14.28%; /* Aproximadamente 100% dividido por 7 */
            height: 50px; /* Altura fija para asegurar tamaño uniforme */
        }
        .today {
            font-weight: bold;
        }
        .navigation-buttons {
            margin-top: 20px;
            display: flex;
            justify-content: center;
            align-items: center;
            gap: 10px;
        }
        .month-year {
            display: inline-block;
            font-size: 1.5em;
        }
        .day-number {
            font-size: 0.8em;
            position: absolute;
            top: 2px;
            left: 5px;
        }
        .turno {
            display: inline-block;
            padding: 2px 5px;
            border-radius: 5px;
            color: white;
            margin-top: 15px;
        }
        .turno.ausente {
            background-color: red;
        }
        .turno.presente {
            background-color: green;
        }
        .turno.pendiente {
            background-color: gray;
        }
    </style>
</head>
<body>
<div class="header">
<b>Bienvenido ${Usuario.nombre_usuario}</b>
</div>
<div class="container">
<div class="content">

	<table class="tabla">
		<tr>
			<td class="columnaLateral"> </td>
			<td class="columnaCentral"></td>
			<td class="columnaCentral"></td>
			<td class="columnaLateral"> <a href="inicio.html"> Cerrar Sesion </a>  </td>
		</tr>
		<tr>
			<td class="columnaLateral"></td>
			<td class="columnaCentral"></td>
			<td class="columnaCentral"></td>
			<td class="columnaLateral">(vuelve a Login al cerrar sesion)</td>
		</tr>
		<tr>
			<td class="columnaLateral"></td>
			<td class="columnaCentral"></td>
			<td class="columnaCentral"> <a href="verTurnos.html"> Ver Detalle de Turnos </a> </td>
			<td class="columnaLateral"></td>
		</tr>
		
	</table>

<!-- Contenedor para el mes y año actuales y los botones de navegación -->
<div class="navigation-buttons">
    <button onclick="cambiarMes(-1)"> <- </button>
    <div id="currentMonthYear" class="month-year"></div>
    <button onclick="cambiarMes(1)"> -> </button>
</div>

<!-- Contenedor del calendario -->
<div id="calendarContainer"></div>

${mensaje}

<script>
    var currentDate = new Date();

    function generarCalendario(year, month) {
        console.log('Generando calendario...');

        var calendarContainer = document.getElementById('calendarContainer');
        calendarContainer.innerHTML = '';

        var calendar = document.createElement('table');
        calendar.className = 'calendar';

        // Crear encabezado de días de la semana
        var headerRow = document.createElement('tr');
        var daysOfWeek = ['Dom', 'Lun', 'Mar', 'Mié', 'Jue', 'Vie', 'Sáb'];
        daysOfWeek.forEach(function(day) {
            var th = document.createElement('th');
            th.innerText = day;
            headerRow.appendChild(th);
        });
        calendar.appendChild(headerRow);

        // Mostrar el mes y año actuales
        var monthNames = ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'];
        var currentMonthYear = document.getElementById('currentMonthYear');
        currentMonthYear.innerText = monthNames[month] + ' ' + year;

        // Calcular el primer día del mes y el primer día de la semana del mes actual
        var firstDayOfMonth = new Date(year, month, 1);
        var firstDayOfWeek = firstDayOfMonth.getDay();

        // Calcular días en el mes actual
        var daysInMonth = new Date(year, month + 1, 0).getDate();

        // Variable para mantener la fecha actual mientras se construye el calendario
        var currentCalendarDate = new Date(year, month, 1 - firstDayOfWeek);

        // Obtener el día actual
        var today = new Date();

        // Crear un objeto para mapear fechas a turnos
        var turnos = {};
        <c:forEach var="turno" items="${turnos}">
            var fecha = '${turno.fecha}'; // Asumimos formato DD/MM/AAAA
            var hora = '${turno.hora}';
            var estado = '${turno.estadoTurno}'; // Asumimos estadoTurno con valores "Ausente", "Presente", "Pendiente"
            if (!turnos[fecha]) {
                turnos[fecha] = [];
            }
            turnos[fecha].push({ hora: hora, estado: estado });
        </c:forEach>

        // Crear filas para los días del mes
        for (var row = 0; row < 6; row++) { // Máximo de 6 filas en un mes
            var tr = document.createElement('tr');

            for (var col = 0; col < 7; col++) {
                var cell = document.createElement('td');
                cell.style.position = 'relative';

                if (currentCalendarDate.getMonth() === month) {
                    var dayNumber = document.createElement('div');
                    dayNumber.className = 'day-number';
                    dayNumber.innerText = currentCalendarDate.getDate();
                    cell.appendChild(dayNumber);

                    // Marcar el día actual en negrita
                    if (currentCalendarDate.getDate() === today.getDate() && currentCalendarDate.getMonth() === today.getMonth() && currentCalendarDate.getFullYear() === today.getFullYear()) {
                        cell.classList.add('today');
                    }

                    // Formatear la fecha como DD/MM/AAAA
                    var dia = ('0' + currentCalendarDate.getDate()).slice(-2);
                    var mes = ('0' + (currentCalendarDate.getMonth() + 1)).slice(-2);
                    var anio = currentCalendarDate.getFullYear();
                    var fechaFormateada = dia + '/' + mes + '/' + anio;

                    // Mostrar los turnos correspondientes a la fecha
                    if (turnos[fechaFormateada]) {
                        turnos[fechaFormateada].forEach(function(turno) {
                            var turnoDiv = document.createElement('div');
                            turnoDiv.innerText = turno.hora;
                            turnoDiv.className = 'turno';

                            // Aplicar el color de fondo basado en el estado del turno
                            if (turno.estado === 'Ausente') {
                                turnoDiv.classList.add('ausente');
                            } else if (turno.estado === 'Presente') {
                                turnoDiv.classList.add('presente');
                            } else if (turno.estado === 'Pendiente') {
                                turnoDiv.classList.add('pendiente');
                            }

                            cell.appendChild(turnoDiv);
                        });
                    }
                } else {
                    cell.style.backgroundColor = '#f0f0f0'; // Diferenciar los días de meses anteriores o siguientes
                }

                // Avanzar al siguiente día
                currentCalendarDate.setDate(currentCalendarDate.getDate() + 1);
                tr.appendChild(cell);
            }

            calendar.appendChild(tr);
        }

        // Mostrar el calendario en el contenedor
        calendarContainer.appendChild(calendar);
    }

    function cambiarMes(increment) {
        currentDate.setMonth(currentDate.getMonth() + increment);
        generarCalendario(currentDate.getFullYear(), currentDate.getMonth());
    }

    // Generar el calendario inicial
    generarCalendario(currentDate.getFullYear(), currentDate.getMonth());
</script>
</div>
</div>
<div class="footer">
        <p>&copy; 2024 Sistema de Gestión Médica</p>
    </div>
</body>
</body>
</html>