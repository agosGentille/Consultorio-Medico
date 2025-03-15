package frgp.utn.edu.ar.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidades.Medico;
import frgp.utn.edu.ar.entidades.Paciente;
import frgp.utn.edu.ar.negocioImp.PacienteNegocio;


@Controller
public class ControladorPacientes {

	@Autowired
    private PacienteNegocio pacienteNegocio;
    
    @Autowired
    private Paciente paciente;

    public void init(ServletConfig config) {
		
    	ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
    	
		this.pacienteNegocio = (PacienteNegocio) appContext.getBean("beanPacienteNegocio");
		this.paciente = (Paciente) appContext.getBean("beanPaciente");
		
	}
    
    @RequestMapping("altaPaciente.html")
    public ModelAndView altaMedicoForm() {
        ModelAndView MV = new ModelAndView();
        MV.addObject("paciente", this.paciente);
        MV.setViewName("AltaPaciente");
        return MV;
    }
    
    @RequestMapping("modificarPacientes.html")
    public ModelAndView modificarMedicoForm() {
        ModelAndView MV = new ModelAndView();
        MV.setViewName("ModificarPacientes");
        return MV;
    }
    
    @RequestMapping("listarPacientes.html")
    public ModelAndView listarPacientes(@RequestParam(defaultValue = "true") boolean ddlFiltroEstado,
    		@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
    	ModelAndView MV = new ModelAndView();
    	
    	List<Paciente> pacientes = pacienteNegocio.findPaginated(page, size);
        
        long totalItems = pacienteNegocio.count();
        int totalPages = (int) Math.ceil((double) totalItems / size);

        MV.addObject("pacientes", pacientes);
        MV.addObject("totalPages", totalPages);
        MV.addObject("currentPage", page);
        MV.addObject("busqueda", false);
        MV.addObject("filtro", false);
        MV.addObject("ddlFiltroEstado", ddlFiltroEstado);
        MV.setViewName("BajaListadoPacientes");
        return MV;
    }
    
    @RequestMapping(value = "buscarPaciente.html", method = RequestMethod.GET)
    public ModelAndView buscarMedico(Integer txtDni) {
        ModelAndView MV = new ModelAndView();
        this.paciente = this.pacienteNegocio.ReadOnePaciente(txtDni);
        if (this.paciente != null) {
            MV.addObject("paciente", this.paciente);
        }
        MV.setViewName("ModificarPacientes");
        return MV;
    }
    
    @RequestMapping(value = "modificarPaciente.html", method = RequestMethod.POST)
    public ModelAndView modificarMedico(int DNI, String txtNombre, String txtApellido, String txtFecha,
            String txtDireccion, String txtLocalidad, String txtProvincia, String txtEmail,
            String txtTelefono, boolean ddlEstado) {
        ModelAndView MV = new ModelAndView();
        boolean estado = false;
        this.paciente = this.pacienteNegocio.ReadOnePaciente(DNI);
        if (this.paciente != null) {
        	this.paciente.setDNI(DNI);
            this.paciente.setNombre(txtNombre);
            this.paciente.setApellido(txtApellido);
            this.paciente.setFechaNac(txtFecha);
            this.paciente.setDireccion(txtDireccion);
            this.paciente.setLocalidad(txtLocalidad);
            this.paciente.setProvincia(txtProvincia);
            this.paciente.setCorreo(txtEmail);
            this.paciente.setTelefono(Integer.parseInt(txtTelefono));
            this.paciente.setEstado(ddlEstado);

        	estado = this.pacienteNegocio.UpdatePaciente(this.paciente);
        	
        }
        
        String cartel = "No se pudo modificar el paciente";
        if (estado) {
            cartel = "El paciente ha sido modificado exitosamente";
        }
        MV.addObject("estadoModificarPaciente", cartel);
        MV.setViewName("ModificarPacientes");
        return MV;
        
    }
    
    @RequestMapping("agregarPaciente.html")
    public ModelAndView agregarPaciente(int txtDni, String txtNombre, String txtApellido, String txtFechaNacimiento,
                                      String txtDireccion, String txtLocalidad, String txtProvincia, String txtCorreo,
                                      String txtTelefono) {
        ModelAndView MV = new ModelAndView();

        String cartel = "El dni ingresado ya se encuentra en la base de datos";
        
        if(this.pacienteNegocio.ReadOnePaciente(txtDni) == null) {
        
	        this.paciente.setDNI(txtDni);
	        this.paciente.setNombre(txtNombre);
	        this.paciente.setApellido(txtApellido);
	        this.paciente.setFechaNac(txtFechaNacimiento);
	        this.paciente.setDireccion(txtDireccion);
	        this.paciente.setLocalidad(txtLocalidad);
	        this.paciente.setProvincia(txtProvincia);
	        this.paciente.setCorreo(txtCorreo);
	        this.paciente.setTelefono(Integer.parseInt(txtTelefono));
	        this.paciente.setEstado(true);
	
	
	        boolean estado = this.pacienteNegocio.AddPaciente(this.paciente);
	        cartel = "No se pudo agregar al paciente";
	        if (estado) {
	            cartel = "El paciente ha sido agregado exitosamente";
	        }
        
        }
        MV.addObject("estadoAgregarPaciente", cartel);
        MV.addObject("paciente", this.paciente);
        MV.setViewName("AltaPaciente");
        return MV;
    }
    
    
    @RequestMapping(value = "buscarPacienteDinamico.html", method = RequestMethod.GET)
    public ModelAndView buscarMedicoDinamico(@RequestParam("txtNombre") String nombre,
    		@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        ModelAndView MV = new ModelAndView();
        
        List<Paciente> Pacientes = pacienteNegocio.findPaginatedBusqueda(page, size, nombre);
        
        long totalItems = pacienteNegocio.countBusqueda(nombre);
        int totalPages = (int) Math.ceil((double) totalItems / size);
        
        if(page > totalPages) {
        	page = 0;
        }
        
        MV.addObject("busqueda", true);
        MV.addObject("filtro", false);
        MV.addObject("totalPages", totalPages);
        MV.addObject("currentPage", page);
        MV.addObject("pacientes", Pacientes);
        MV.setViewName("BajaListadoPacientes");
        return MV;
    }
    
    @RequestMapping(value = "bajaPaciente.html", method = RequestMethod.POST)
    public ModelAndView bajaMedico(int DNI, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        ModelAndView MV = new ModelAndView();
        this.paciente = this.pacienteNegocio.ReadOnePaciente(DNI);
        if (paciente != null) {
        	this.paciente.setEstado(false);
            this.pacienteNegocio.UpdatePaciente(paciente);
        }

        MV.addObject("mensaje", "Se ha eliminado el paciente exitosamente");
        
        MV.setViewName("redirect:listarPacientes.html");
        
        return MV;
    }
    
    @RequestMapping(value = "cambiarAltaPaciente.html", method = RequestMethod.POST)
    public ModelAndView cambiarAltaPaciente(int DNI, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        ModelAndView MV = new ModelAndView();
        this.paciente = this.pacienteNegocio.ReadOnePaciente(DNI);
        if (paciente != null) {
        	this.paciente.setEstado(true);
            this.pacienteNegocio.UpdatePaciente(paciente);
        }
        
        MV.addObject("mensaje", "Se ha dado de alta al paciente exitosamente");
        
        MV.setViewName("redirect:listarPacientes.html");
        return MV;
    }
    
    @RequestMapping(value = "listarPacientesFiltro.html", method = RequestMethod.GET)
    public ModelAndView ListarPacientesConFiltroPorEstado(@RequestParam("ddlFiltroEstado") String ddlFiltroEstado,
    		@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        
    	ModelAndView MV = new ModelAndView();
        
    	boolean estado = Boolean.valueOf(ddlFiltroEstado);
        
        List<Paciente> Pacientes = pacienteNegocio.findPaginatedConFiltro(page, size, estado);
        
        long totalItems = pacienteNegocio.countConFiltro(estado);
        int totalPages = (int) Math.ceil((double) totalItems / size);

        if(page > totalPages) {
        	page = 0;
        }
        
        MV.addObject("busqueda", false);
        MV.addObject("filtro", true);
        MV.addObject("totalPages", totalPages);
        MV.addObject("currentPage", page);
        MV.addObject("ddlFiltroEstado", estado);
        
        MV.addObject("pacientes", Pacientes);
        
        MV.setViewName("BajaListadoPacientes");
        return MV;
    }
    
    
    
}