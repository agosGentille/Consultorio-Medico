package frgp.utn.edu.ar.controller;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.servlet.ServletConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidades.Medico;
import frgp.utn.edu.ar.entidades.Usuario;
import frgp.utn.edu.ar.negocioImp.EspecialidadNegocio;
import frgp.utn.edu.ar.negocioImp.MedicoNegocio;
import frgp.utn.edu.ar.negocioImp.UsuarioNegocio;

@Controller
public class ControladorMedicos {

	@Autowired
    private MedicoNegocio medicoNegocio;

    @Autowired
    private EspecialidadNegocio especialidadNegocio;

    @Autowired
    private UsuarioNegocio usuarioNegocio;
    
    @Autowired
    private Medico medico;
    
    @Autowired
    private Usuario usuario;
    
    public void init(ServletConfig config) {
        try (ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml")) {
            this.medicoNegocio = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
            this.especialidadNegocio = (EspecialidadNegocio) appContext.getBean("beanEspecialidadNegocio");
            this.usuarioNegocio = (UsuarioNegocio) appContext.getBean("beanUsuarioNegocio");
            this.medico = (Medico) appContext.getBean("beanMedico");
            this.usuario = (Usuario) appContext.getBean("beanUsuario");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    @RequestMapping("agregarMedico.html")
    public ModelAndView agregarMedico(String txtNombre, String txtApellido, String txtFechaNacimiento,
                                      String txtDireccion, String txtLocalidad, String ddlSexo,
                                      Integer ddlEspecialidad, String txtTelefono, String txtEmail, String[] chkdiasTrabajo ,
                                      String txtHoraEnt,String txtMinutoEnt, String txtHoraSal, String txtMinutoSal,  
                                      Boolean ddlEstado, String txtUsuario, String txtContra, String txtContraX2) {
        ModelAndView MV = new ModelAndView();
        
        String cartel = null;
        boolean validarHoraEnt = true;
        boolean validarHoraSal = true;
        if(txtHoraEnt.isEmpty() || txtMinutoSal.isEmpty()) validarHoraEnt = false;
        if(txtHoraSal.isEmpty() || txtMinutoSal.isEmpty()) validarHoraSal = false;
        
        if (validarHoraEnt) {
            try {
                int hora = Integer.parseInt(txtHoraEnt);
                int minuto = Integer.parseInt(txtMinutoEnt);
                // LocalTime validar� si la hora est� en el rango de 0 a 23 y los minutos en el rango de 0 a 59
                LocalTime.of(hora, minuto);
            } catch (DateTimeParseException e) {
                validarHoraEnt = false;
            } catch (NumberFormatException e) {
                validarHoraEnt = false;
            }
        }
        
        if (validarHoraSal) {
            try {
                int hora = Integer.parseInt(txtHoraSal);
                int minuto = Integer.parseInt(txtMinutoSal);
                // LocalTime validar� si la hora est� en el rango de 0 a 23 y los minutos en el rango de 0 a 59
                LocalTime.of(hora, minuto);
            } catch (DateTimeParseException e) {
                validarHoraSal = false;
            } catch (NumberFormatException e) {
                validarHoraSal = false;
            }
        }
        
        if(txtContra.equals(txtContraX2)) {
        	if(this.usuarioNegocio.Exist(txtUsuario)) {
        		cartel = "El usuario ingresado ya se encuentra en uso.";
        	}
        	else {
        		if(validarHoraEnt && validarHoraSal) {
        			this.medico.setLegajo(this.medicoNegocio.traerProximoLegajo());
    		        this.medico.setNombre(txtNombre);
    		        this.medico.setApellido(txtApellido);
    		        this.medico.setFechaNacimiento(txtFechaNacimiento);
    		        this.medico.setDireccion(txtDireccion);
    		        this.medico.setLocalidad(txtLocalidad);
    		        this.medico.setSexo(ddlSexo.charAt(0));
    		        this.medico.setEspecialidad(this.especialidadNegocio.getEspecialidadById(ddlEspecialidad));
    		        this.medico.setTelefono(Integer.parseInt(txtTelefono));
    		        this.medico.setEmail(txtEmail);
    		        String DiasQueTrabaja = "";
    		        for(String Dia : chkdiasTrabajo) {
    		        	DiasQueTrabaja = DiasQueTrabaja + Dia + ","; 
    		        }
    		        this.medico.setDiasQueTrabaja(DiasQueTrabaja);
    		        this.medico.setHoraEntrada(txtHoraEnt + ":" + txtMinutoEnt);
    		        this.medico.setHoraSalida(txtHoraSal + ":" + txtMinutoSal);
    		        this.medico.setEstado(ddlEstado);
    		        
    		        this.usuario.setNombre_usuario(txtUsuario);
    		        this.usuario.setContrasenia(txtContra);
    		        this.usuario.setEstado(true);
    		        
    		        if(this.usuarioNegocio.Add(this.usuario)) {
    		        	this.medico.setUsuario(this.usuario);
    			        boolean estado = this.medicoNegocio.Add(this.medico);
    			        cartel = "No se pudo agregar el medico";
    			        if (estado) {
    			        	cartel = "El medico ha sido agregado exitosamente";
    			        }
    		        }else {
    		        	cartel = "Error al guardar el usuario. Consecuentemente no se ha guardado al medico.";
    		        }
        		}else {
        			cartel = "Verifique que el formato de hora de entrada y salida cumplan con el formato 24hs";
        		}
        		
		        
        	}  
        }else {
        	cartel = "Las claves no coinciden.";
        }
        
        MV.addObject("estadoAgregarMedico", cartel);
        MV.addObject("medico", this.medico);
        MV.addObject("especialidades", especialidadNegocio.getAllEspecialidades());
        MV.addObject("usuarios", usuarioNegocio.ReadAll());
        MV.setViewName("AltaMedicos");
        return MV;
    }

    @RequestMapping("altaMedico.html")
    public ModelAndView altaMedicoForm() {
        ModelAndView MV = new ModelAndView();
        MV.addObject("medico", this.medico);
        MV.addObject("especialidades", especialidadNegocio.getAllEspecialidades());
        MV.addObject("usuarios", usuarioNegocio.ReadAll());
        MV.setViewName("AltaMedicos");
        return MV;
    }

    @RequestMapping("listarMedicos.html")
    public ModelAndView listarMedicos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "true") boolean ddlFiltroEstado) {
    	int size = 5;

        ModelAndView MV = new ModelAndView();
        List<Medico> medicos;
        long totalItems;
        
        medicos = medicoNegocio.findPaginated(page, size);
        totalItems = medicoNegocio.count();
        
        int totalPages = (int) Math.ceil((double) totalItems / size);
        totalPages = totalPages == 0 ? 1 : totalPages;

        String mensaje = "";
        if(medicos.isEmpty()) {
        	mensaje = "No se encontraron resultados para la búsqueda.";
            MV.addObject("noResultados", true);  // Indica que no hay resultados
        } else {
            MV.addObject("noResultados", false); // Indica que hay resultados
        }
        
        
        MV.addObject("medicos", medicos);
        MV.addObject("totalPages", totalPages);
        MV.addObject("currentPage", page);
        MV.addObject("ddlFiltroEstado", ddlFiltroEstado);
        MV.addObject("filtro", false);
        MV.addObject("busqueda", false);
        MV.addObject("errorBusquedaNula", mensaje);
        MV.setViewName("BajaListadoMedicos");
        return MV;
    }
    
    @RequestMapping("modificarMedicos.html")
    public ModelAndView modificarMedicosForm() {
        ModelAndView MV = new ModelAndView();
        MV.setViewName("ModificarMedicos");
        return MV;
    }

    @RequestMapping(value = "bajaMedico.html", method = RequestMethod.POST)
    public ModelAndView bajaMedico(Integer legajo, 
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "true") boolean ddlFiltroEstado) {
    	int size = 3;
        ModelAndView MV = new ModelAndView();
        this.medico = this.medicoNegocio.ReadOne(legajo);
        if (medico != null) {
        	this.medico.setEstado(false);
            this.medicoNegocio.Update(this.medico);
            this.usuario = this.usuarioNegocio.ReadOne(this.medico.getUsuario().getNombre_usuario());
            this.usuario.setEstado(false);
            this.usuarioNegocio.Update(this.usuario);
        }
       
        MV.addObject("mensaje","Se ha eliminado el medico exitosamente");

        MV.setViewName("redirect:listarMedicos.html");
        
        return MV;
    }
    
    @RequestMapping(value = "cambiarAltaMedico.html", method = RequestMethod.POST)
    public ModelAndView CambiarAltaMedico(Integer legajo, 
    		 @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "true") boolean ddlFiltroEstado) {
     	int size = 3;
        ModelAndView MV = new ModelAndView();
        this.medico = this.medicoNegocio.ReadOne(legajo);
        if (medico != null) {
        	this.medico.setEstado(true);
            this.medicoNegocio.Update(medico);
            this.usuario = this.usuarioNegocio.ReadOne(this.medico.getUsuario().getNombre_usuario());
            this.usuario.setEstado(true);
            this.usuarioNegocio.Update(this.usuario);
        }
        
        MV.addObject("mensaje","Se ha dado de alta al medico exitosamente");

        MV.setViewName("redirect:listarMedicos.html");
        
        return MV;
    }

    @RequestMapping(value = "buscarMedico.html", method = RequestMethod.GET)
    public ModelAndView buscarMedico(Integer txtLegajo) {
        ModelAndView MV = new ModelAndView();
        this.medico = this.medicoNegocio.ReadOne(txtLegajo);
        if (this.medico != null) {
        	String diasTrabajo = this.medico.getDiasQueTrabaja();
        	String[] diasSeleccionados = diasTrabajo.split(",");
        	
        	String strHoraEntrada = this.medico.getHoraEntrada(); 
        	String strHoraSalida = this.medico.getHoraSalida(); 

        	String[] partsHoraEntrada = strHoraEntrada.split(":");
        	String sEntradaHora = partsHoraEntrada[0]; 
        	String sEntradaMinuto = partsHoraEntrada[1]; 

        	// Separar la hora y el minuto para la hora de salida
        	String[] partsHoraSalida = strHoraSalida.split(":");
        	String sSalidaHora = partsHoraSalida[0]; 
        	String sSalidaMinuto = partsHoraSalida[1]; 
        	
        	MV.addObject("horaEntr", sEntradaHora);
        	MV.addObject("minEntr", sEntradaMinuto);
        	
        	MV.addObject("horaSal", sSalidaHora);
        	MV.addObject("minSal", sSalidaMinuto);
        	
        	
        	MV.addObject("diasSeleccionados", diasSeleccionados);
            MV.addObject("medico", this.medico);
            MV.addObject("especialidades", this.especialidadNegocio.getAllEspecialidades());
            MV.addObject("usuario", this.usuarioNegocio.ReadOne(this.medico.getUsuario().getNombre_usuario()));
        }
        MV.setViewName("ModificarMedicos");
        return MV;
    }

    @RequestMapping(value = "modificarMedico.html", method = RequestMethod.POST)
    public ModelAndView modificarMedico(Integer legajo, String txtNombre, String txtApellido, String txtFechaNacimiento,
                                        String txtDireccion, String txtLocalidad, String ddlSexo, Integer ddlEspecialidad,
                                        String txtTelefono, String txtEmail, String[] chkdiasTrabajo, 
                                        String txtHoraEnt,String txtMinutoEnt, String txtHoraSal, String txtMinutoSal,
                                        Boolean ddlEstado, String txtUsuario, String txtContra) {
        ModelAndView MV = new ModelAndView();
        boolean estado = false;
        
        boolean validarHoraEnt = true;
        boolean validarHoraSal = true;
        if(txtHoraEnt.isEmpty() || txtMinutoSal.isEmpty()) validarHoraEnt = false;
        if(txtHoraSal.isEmpty() || txtMinutoSal.isEmpty()) validarHoraSal = false;
        
        if (validarHoraEnt) {
            try {
                int hora = Integer.parseInt(txtHoraEnt);
                int minuto = Integer.parseInt(txtMinutoEnt);
                // LocalTime validar� si la hora est� en el rango de 0 a 23 y los minutos en el rango de 0 a 59
                LocalTime.of(hora, minuto);
            } catch (DateTimeParseException e) {
                validarHoraEnt = false;
            } catch (NumberFormatException e) {
                validarHoraEnt = false;
            }
        }
        
        if (validarHoraSal) {
            try {
                int hora = Integer.parseInt(txtHoraSal);
                int minuto = Integer.parseInt(txtMinutoSal);
                // LocalTime validar� si la hora est� en el rango de 0 a 23 y los minutos en el rango de 0 a 59
                LocalTime.of(hora, minuto);
            } catch (DateTimeParseException e) {
                validarHoraSal = false;
            } catch (NumberFormatException e) {
                validarHoraSal = false;
            }
        }
        

        
        this.medico = this.medicoNegocio.ReadOne(legajo);
        if (this.medico != null) {
        	if(validarHoraEnt && validarHoraSal) {
        		//Obtengo el usuario antes de que el medico se modifique para poder evaluar si se modifico el nombre o no
        		this.usuario = this.medico.getUsuario();
        		
        		//Validacion de que si el usuario se ha modificado, no sea igual a un usuario previamente ingresado
        		if(!this.usuario.getNombre_usuario().equals(txtUsuario) && this.usuarioNegocio.Exist(txtUsuario)) {
        			String cartel = "El usuario ingresado ya existio previamente. La modificacion ha sido cancelada.";
        	        MV.addObject("estadoAgregarMedico", cartel);
        	        MV.setViewName("ModificarMedicos");
        	        return MV;
        		}
            	
            	this.medico.setNombre(txtNombre);
            	this.medico.setApellido(txtApellido);
            	this.medico.setFechaNacimiento(txtFechaNacimiento);
            	this.medico.setDireccion(txtDireccion);
            	this.medico.setLocalidad(txtLocalidad);
            	this.medico.setEmail(txtEmail);
            	this.medico.setSexo(ddlSexo.charAt(0));
            	this.medico.setEspecialidad(this.especialidadNegocio.getEspecialidadById(ddlEspecialidad));
            	this.medico.setTelefono(Integer.parseInt(txtTelefono));
            	String DiasQueTrabaja = "";
		        for(String Dia : chkdiasTrabajo) {
		        	DiasQueTrabaja = DiasQueTrabaja + Dia + ","; 
		        }
            	this.medico.setDiasQueTrabaja(DiasQueTrabaja);
            	this.medico.setHoraEntrada(txtHoraEnt + ":" + txtMinutoEnt);
            	this.medico.setHoraSalida(txtHoraSal + ":" + txtMinutoSal);
            	
            	this.medico.setEstado(ddlEstado);
            	
        		this.usuario.setContrasenia(txtContra);
        		
            	//Evaluo si se modifico el nombre de usuario. Si se modifico hay que crear uno nuevo con ese nombre.
            	if(this.usuario.getNombre_usuario().equals(txtUsuario)) {
            		this.usuarioNegocio.Update(this.usuario);
            	}
            	else {
            		//Le pongo estado false al usuario viejo
            		this.usuario.setEstado(false);
            		this.usuarioNegocio.Update(this.usuario);
            		
            		//Agrego el nuevo usuario
            		this.usuario.setNombre_usuario(txtUsuario);
            		this.usuario.setEstado(true);
            		this.usuarioNegocio.Add(this.usuario);
            		
            	}
                
            	estado = this.medicoNegocio.Update(this.medico);
        	}
        }
        
        String cartel = "No se pudo agregar el medico";
        if (estado) {
            cartel = "El medico ha sido modificado exitosamente";
        }
        MV.addObject("estadoAgregarMedico", cartel);
        MV.setViewName("ModificarMedicos");
        return MV;
        
    }
    
    @RequestMapping(value = "buscarMedicoDinamico.html", method = RequestMethod.GET)
    public ModelAndView buscarMedicoDinamico(@RequestParam("txtNombre") String nombre, 
    		@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        
    	ModelAndView MV = new ModelAndView();

        List<Medico> medicos = medicoNegocio.findPaginatedBusqueda(page, size, nombre);
        
        long totalItems = medicoNegocio.countBusqueda(nombre);
        int totalPages = (int) Math.ceil((double) totalItems / size);
        
        if(page > totalPages) {
        	page = 0;
        }
        
        String mensaje = "";
        if(medicos.isEmpty()) {
        	mensaje = "No se encontraron resultados para la búsqueda.";
            MV.addObject("noResultados", true);  // Indica que no hay resultados
        } else {
            MV.addObject("noResultados", false); // Indica que hay resultados
        }
        
        MV.addObject("medicos", medicos);
        MV.addObject("busqueda", true);
        MV.addObject("filtro", false);
        MV.addObject("totalPages", totalPages);
        MV.addObject("currentPage", page);
        MV.addObject("errorBusquedaNula", mensaje);
        MV.setViewName("BajaListadoMedicos");
        return MV;
    }
    
    @RequestMapping(value = "listarMedicosFiltro.html", method = RequestMethod.GET)
    public ModelAndView ListarMedicosConFiltroPorEstado(@RequestParam("ddlFiltroEstado") String EstadoFiltro,
    		@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        
    	ModelAndView MV = new ModelAndView();
        boolean estado = Boolean.valueOf(EstadoFiltro);
        
        List<Medico> medicos = medicoNegocio.findPaginatedConFiltro(page, size, estado);
        
        
        long totalItems = medicoNegocio.countConFiltro(estado);
        int totalPages = (int) Math.ceil((double) totalItems / size);
        
        if(page > totalPages) {
        	page = 0;
        }
        String mensaje = "";
        if(medicos.isEmpty()) {
        	mensaje = "No se encontraron resultados para la búsqueda.";
            MV.addObject("noResultados", true);  // Indica que no hay resultados
        } else {
            MV.addObject("noResultados", false); // Indica que hay resultados
        }
	    
        MV.addObject("medicos", medicos);
        MV.addObject("totalPages", totalPages);
        MV.addObject("currentPage", page);
        MV.addObject("busqueda", false);
        MV.addObject("filtro", true);
        MV.addObject("ddlFiltroEstado", EstadoFiltro);
        MV.addObject("errorBusquedaNula", mensaje);
        MV.setViewName("BajaListadoMedicos");
        return MV;
    }

}
