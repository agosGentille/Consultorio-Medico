 package frgp.utn.edu.ar.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidades.Especialidad;
import frgp.utn.edu.ar.entidades.Medico;
import frgp.utn.edu.ar.entidades.Paciente;
import frgp.utn.edu.ar.entidades.Turno;
import frgp.utn.edu.ar.entidades.Usuario;
import frgp.utn.edu.ar.negocioImp.EspecialidadNegocio;
import frgp.utn.edu.ar.negocioImp.MedicoNegocio;
import frgp.utn.edu.ar.negocioImp.PacienteNegocio;
import frgp.utn.edu.ar.negocioImp.TurnosNegocio;


@Controller
public class ControladorTurnos {

	@Autowired
    private TurnosNegocio turnoNegocio;
    
    @Autowired
    private Turno turno;
    
    @Autowired
    private List<Turno> turnos;
    
    @Autowired
    private MedicoNegocio medNegocio;
    
    @Autowired
    private Medico medico;
    
    @Autowired
    private Paciente paciente;
    
    @Autowired
    private PacienteNegocio pacNegocio;
    
    @Autowired
    private EspecialidadNegocio espNegocio;
    

    public void init(ServletConfig config) {
		
    	ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
    	
		this.turnoNegocio = (TurnosNegocio) appContext.getBean("beanTurnosNegocio");
		this.turno = (Turno) appContext.getBean("beanTurno");
		this.medico = (Medico) appContext.getBean("beanMedico");
		this.medNegocio = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
		this.paciente = (Paciente) appContext.getBean("beanPaciente");
		this.pacNegocio = (PacienteNegocio) appContext.getBean("beanPacienteNegocio");
		
	}
    

    @RequestMapping("asignarTurnos.html")
    public ModelAndView asignarTurnosForm() {
        ModelAndView MV = new ModelAndView();
        
        List<Especialidad> especialidades = this.espNegocio.getAllEspecialidades();
        List<Paciente> pacientes = this.pacNegocio.ReadAllPacientesDisponibles();
        
        List<Medico> medicos = this.medNegocio.ReadAllXEspecialidad(especialidades.get(0).getId());
    	MV.addObject("medicos",medicos);
        
        MV.addObject("pacientes",pacientes);
        MV.addObject("especialidades",especialidades);
        
        MV.setViewName("AsignarTurnos");
        return MV;
    }
    
    @RequestMapping("crearTurno.html")
    public ModelAndView crearTurnos(int ddlPaciente, int ddlMedico, 
    		String txtDia, String txtMes, String txtAnio, String txtHora, String txtMinuto) {
    	ModelAndView MV = new ModelAndView();
    	String cartel = "";
    	boolean validarFecha = true;
    	boolean validarHora = true;
    	boolean validarMedico = true;
    	
    	if(txtDia.isEmpty() || txtMes.isEmpty() || txtAnio.isEmpty()) validarFecha = false;
    	if(txtHora.isEmpty() || txtMinuto.isEmpty()) validarHora = false;
    	if(String.valueOf(ddlMedico).isEmpty()) {
    		validarMedico = false;
    		cartel = "Medico invalido. Por favor seleccione un medico.";
    	}
    	
    	LocalDate fecha = null;
    	if (validarFecha) {
            try {
                int dia = Integer.parseInt(txtDia);
                int mes = Integer.parseInt(txtMes);
                int anio = Integer.parseInt(txtAnio);
                fecha = LocalDate.of(anio, mes, dia);
            } catch (DateTimeParseException e) {
                validarFecha = false;
                cartel = "Fecha invalida. Por favor ingrese una fecha valida.";
            } catch (NumberFormatException e) {
                validarFecha = false;
                cartel = "Fecha invalida. Por favor ingrese una fecha valida.";
            }
        }
    	
    	if (validarHora) {
            try {
                int hora = Integer.parseInt(txtHora);
                int minuto = Integer.parseInt(txtMinuto);
                // LocalTime validarï¿½ si la hora estï¿½ en el rango de 0 a 23 y los minutos en el rango de 0 a 59
                LocalTime time = LocalTime.of(hora, minuto);
            } catch (DateTimeParseException e) {
                validarHora = false;
                cartel = "Hora invalida. Por favor ingrese una hora valida en formato 24 horas.";
            } catch (NumberFormatException e) {
                validarHora = false;
                cartel = "Hora invalida. Por favor ingrese una hora valida en formato 24 horas.";
            }
        }
    	
    	if(validarFecha && validarHora && validarMedico) {
    		this.medico = this.medNegocio.ReadOne(ddlMedico);
    		try {
    	        LocalDateTime fechaHoraTurno = LocalDateTime.of(Integer.parseInt(txtAnio), Integer.parseInt(txtMes), Integer.parseInt(txtDia), Integer.parseInt(txtHora), Integer.parseInt(txtMinuto));
    	        LocalDate fechaTurno = fechaHoraTurno.toLocalDate();
    	        LocalTime horaTurno = fechaHoraTurno.toLocalTime();
    	        
    	        DayOfWeek diaSemanaTurno = fechaTurno.getDayOfWeek();
    	        String diasTrabajo = this.medico.getDiasQueTrabaja();
    	        String[] diasTrabajoArray = diasTrabajo.split(",");
    	        String nombreDiaTurno = diaSemanaTurno.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
    	        boolean diaValido = false;
    	        for (String dia : diasTrabajoArray) {
    	        	if(dia.equals("Miercoles")) {
    	        		dia = "Miércoles";
    	        	}
    	        	if(dia.equals("Sabado")) {
    	        		dia = "Sábado";
    	        	}
    	        	if (nombreDiaTurno.equalsIgnoreCase(dia.trim())) {
    	                diaValido = true;
    	                break;
    	            }
    	        }
    	        if (!diaValido) {
    	            cartel = "El medico no trabaja los dias " + nombreDiaTurno + ", por favor seleccione otra fecha.";
    	        } else {
	    	        List<Turno> turnosMedico = turnoNegocio.obtenerTurnosPorMedicoYFecha(ddlMedico, fechaHoraTurno.toLocalDate());
	    	        LocalTime horaSalida = LocalTime.parse(this.medico.getHoraSalida());
	    	        
	    	        // Calcular el horario mï¿½nimo y mï¿½ximo para asignar turnos
	    	        LocalDateTime horaInicioLimite = LocalDateTime.of(fechaTurno, horaSalida.minusMinutes(59));
	    	        LocalDateTime horaFinLimite = LocalDateTime.of(fechaTurno, horaSalida);
	
	    	        // Validar si el horario propuesto estï¿½ dentro de los lï¿½mites y no se superpone con otros turnos
	    	        if (!fechaHoraTurno.isBefore(horaInicioLimite) || fechaHoraTurno.isAfter(horaFinLimite)) {
	    	            cartel = "El turno debe estar dentro del horario permitido (hasta una hora antes de la salida del medico).";
	    	        } else {
	    	            boolean turnoSuperpuesto = false;
	    	            for (Turno turno : turnosMedico) {
	    	            	String[] HoraPartida = turno.getHora().split(":");
	    	            	int iHora = Integer.valueOf(HoraPartida[0]);
	    	            	int iMin = Integer.valueOf(HoraPartida[1]);
	    	                LocalTime turnoInicio = LocalTime.of(iHora, iMin);
	    	                LocalTime turnoFin = turnoInicio.plusHours(1); 
	
	    	                if (horaTurno.equals(turnoInicio) || (horaTurno.isAfter(turnoInicio) && horaTurno.isBefore(turnoFin))) {
	    	                    turnoSuperpuesto = true;
	    	                    break;
	    	                }
	    	            }
	
	    	            if (turnoSuperpuesto) {
	    	                cartel = "El turno se superpone con otro turno existente.";
	    	            } else {
	    	            	this.paciente = this.pacNegocio.ReadOnePaciente(ddlPaciente);
	    			    	this.turno.setPaciente(this.paciente);
	    			    	this.turno.setMedico(this.medico);
	    			    	
	    			    	String setFecha = txtDia + "/" + txtMes + "/" + txtAnio;
	    			    	this.turno.setFecha(setFecha);
	    			    	
	    			    	String setHora = txtHora + ":" + txtMinuto;
	    			    	this.turno.setHora(setHora);
	    			    	
	    			    	this.turno.setEstadoRegistro(true);
	    			    	this.turno.setEstadoTurno("Pendiente");
	    			    	this.turno.setObservaciones("Ninguna");
	    			    	
	    			    	boolean estado = this.turnoNegocio.AddTurno(this.turno);;
	    			    	
	    			    	cartel = estado ? "El turno ha sido agregado exitosamente" : "No se pudo agregar el turno"; 
	    	            }
	    		
	    	        }
    	        }
    		}catch (NumberFormatException | DateTimeParseException ex) {
    	        cartel = "Error al procesar la fecha y hora del turno.";
    	    }
    		       
    	}
	    List<Paciente> pacientes = this.pacNegocio.ReadAllPacientesDisponibles();
	    List<Especialidad> especialidades = this.espNegocio.getAllEspecialidades();
	    List<Medico> medicos = this.medNegocio.ReadAllXEspecialidad(especialidades.get(0).getId());
        
	    MV.addObject("especialidades", especialidades);
	    MV.addObject("pacientes",pacientes);
	    MV.addObject("medicos", medicos);
        MV.addObject("mensaje",cartel);
        MV.setViewName("AsignarTurnos");
        
    	return MV;
    }
    
    private boolean validarTurno(LocalTime horaInicio, List<Turno> turnosExistentes) {
        for (Turno turno : turnosExistentes) {
            LocalTime turnoInicio = LocalTime.parse(turno.getHora()); // Suponiendo que getHora devuelve un String con el formato de hora
            LocalTime turnoFin = turnoInicio.plusHours(1); // Duraciï¿½n del turno de 1 hora

            if (horaInicio.isBefore(turnoFin) && horaInicio.plusHours(1).isAfter(turnoInicio)) {
                return false; // Hay un conflicto de horario
            }
        }
        return true; // No hay conflicto de horario
    }
    
    @RequestMapping(value = "listarMedicosAsignarTurnos.html", method = RequestMethod.POST)
    public ModelAndView ListarMedicosAsignarTurnos(String ddlEspecialidad, String HddlPaciente, String HtxtDia, 
    		String HtxtMes, String HtxtAnio, String HtxtHora, String HtxtMinuto) {
    	ModelAndView MV = new ModelAndView();
        String cartel = "";
        
        if(ddlEspecialidad.equals("")) {
            cartel = "Debe seleccionar una especialidad.";
        } else {
            List<Medico> medicos = this.medNegocio.ReadAllXEspecialidad(Integer.valueOf(ddlEspecialidad));
            MV.addObject("medicos", medicos);
        }
        
        List<Paciente> pacientes = this.pacNegocio.ReadAllPacientesDisponibles();
        MV.addObject("pacientes", pacientes);
        
        List<Especialidad> especialidades = this.espNegocio.getAllEspecialidades();
        MV.addObject("especialidades", especialidades);
        
        MV.addObject("ddlEspecialidadSeleccionada", ddlEspecialidad);
        MV.addObject("ddlPacienteSeleccionado", HddlPaciente);
        MV.addObject("txtDia", HtxtDia);
        MV.addObject("txtMes", HtxtMes);
        MV.addObject("txtAnio", HtxtAnio);
        MV.addObject("txtHora", HtxtHora);
        MV.addObject("txtMinuto", HtxtMinuto);
        MV.addObject("mensaje", cartel);
        MV.setViewName("AsignarTurnos");
        
        return MV;
    }
    
    @RequestMapping("verTurnos.html")
    public ModelAndView verTurnosForm(HttpSession session, 
    		@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size) {
    	ModelAndView MV = new ModelAndView();
    	
    	Usuario usuarioLogeado = (Usuario) session.getAttribute("sessUsuario");
    	
    	this.medico = this.medNegocio.ReadOneConUsuario(usuarioLogeado.getNombre_usuario());
    	
    	this.turnos = this.turnoNegocio.findPaginated(page, size, this.medico.getLegajo());
        
    	long totalItems = this.turnoNegocio.count(this.medico.getLegajo());
        int totalPages = (int) Math.ceil((double) totalItems / size);
        
    	MV.addObject("turnos", this.turnos);
    	MV.addObject("totalPages", totalPages);
        MV.addObject("currentPage", page);
        MV.addObject("Usuario", usuarioLogeado);
        MV.addObject("pageSize", size);
        
        MV.setViewName("VerTurnosMedico");
        
        return MV;
    }
    
    @RequestMapping("cargarPresentismo.html")
    public ModelAndView cargarPresentismoForm(Integer idTurno) {
        ModelAndView MV = new ModelAndView();
        this.turno = this.turnoNegocio.ReadOneTurno(idTurno);
        MV.addObject("turno",this.turno);
        MV.setViewName("CargarPresentismoMedico");
        return MV;
    }
    
    
    @RequestMapping(value = "agregarObs.html", method = RequestMethod.POST)
    public ModelAndView AgregarObservacionesYOcultarControles(String radioEstado, String txtObservaciones, HttpSession session) {
        ModelAndView MV = new ModelAndView();
                
        if(radioEstado != null && txtObservaciones != "") {
        	Turno turnoAgregarObs = this.turnoNegocio.ReadOneTurno(this.turno.getId());
        
        	turnoAgregarObs.setEstadoTurno(radioEstado);
        	turnoAgregarObs.setObservaciones(txtObservaciones);
        
        	this.turnoNegocio.UpdateTurno(turnoAgregarObs);
        	
        }
        
        Usuario usuarioLogeado = (Usuario) session.getAttribute("sessUsuario");
    	
    	this.medico = medNegocio.ReadOneConUsuario(usuarioLogeado.getNombre_usuario());
    	
    	List<Turno> turnos = turnoNegocio.ReadAllTurnosUnMedico(this.medico.getLegajo());
        
    	MV.addObject("turnos", turnos);
        MV.addObject("Usuario", usuarioLogeado);
        MV.addObject("mensaje","Se ha cargado el presentismo con exito");
        MV.setViewName("redirect:verTurnos.html");
        
        return MV;
    }
    
    @RequestMapping("buscarTurno.html")
    public ModelAndView BuscarTurnoForm(Integer txtIdTurno, HttpSession session) {
    	ModelAndView MV = new ModelAndView();
    	
    	Usuario usuarioLogeado = (Usuario) session.getAttribute("sessUsuario");
    	this.medico = medNegocio.ReadOneConUsuario(usuarioLogeado.getNombre_usuario());
    	MV.addObject("Usuario", usuarioLogeado);
    	
    	MV.addObject("turno", null);
    	
    	if(txtIdTurno != null && this.turnoNegocio.Exist(txtIdTurno)) {
	    	Turno turno = this.turnoNegocio.ReadOneTurno(txtIdTurno);
	    	
	    	if(turno.getMedico().getLegajo() == this.medico.getLegajo()) {
	    		MV.addObject("turno", turno);
	    	}
    	}

        MV.setViewName("VerTurnosMedico");
        return MV;
    }
    

}
