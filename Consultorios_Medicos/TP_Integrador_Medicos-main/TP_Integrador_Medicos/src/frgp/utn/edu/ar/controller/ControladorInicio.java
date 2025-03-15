package frgp.utn.edu.ar.controller;

import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidades.Medico;
import frgp.utn.edu.ar.entidades.Turno;
import frgp.utn.edu.ar.entidades.Usuario;
import frgp.utn.edu.ar.negocioImp.MedicoNegocio;
import frgp.utn.edu.ar.negocioImp.TurnosNegocio;
import frgp.utn.edu.ar.negocioImp.UsuarioNegocio;

@Controller
public class ControladorInicio {

	    @Autowired
	    private UsuarioNegocio usuarioNegocio;
	    
	    @Autowired
	    private Usuario usuario;
	    
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
	    
	    
	    public void init(ServletConfig config) {
			
	    	ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
	    	
			this.usuarioNegocio = (UsuarioNegocio) appContext.getBean("beanUsuarioNegocio");
			this.usuario = (Usuario) appContext.getBean("beanUsuario");
			this.turnoNegocio = (TurnosNegocio) appContext.getBean("beanTurnosNegocio");
			this.turno = (Turno) appContext.getBean("beanTurno");
			this.medico = (Medico) appContext.getBean("beanMedico");
			this.medNegocio = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
			
		}
	
	
	@RequestMapping("inicio.html")
	public ModelAndView inicioForm()
	{
		ModelAndView MV = new ModelAndView();
        MV.setViewName("Login");
        return MV;
	}
	
	@RequestMapping("homeAdmin.html")
	public ModelAndView homeAdminForm() {
		ModelAndView MV = new ModelAndView();
        MV.setViewName("HomeAdmin");
		return MV;
	}
	
	@RequestMapping("homeUsuario.html")
	public ModelAndView homeUsuarioForm(HttpSession session) {
		ModelAndView MV = new ModelAndView();
        
        Usuario usuarioLogeado = this.usuario;
        
        this.medico = this.medNegocio.ReadOneConUsuario(usuarioLogeado.getNombre_usuario());
    	
    	this.turnos = this.turnoNegocio.ReadAllTurnosUnMedico(this.medico.getLegajo());
        
    	MV.addObject("turnos", this.turnos);
        MV.addObject("Usuario", usuarioLogeado);
        
        session.setAttribute("Usuario", usuarioLogeado);
        
        MV.setViewName("HomeUsuario");
		
        return MV;
	}
	
	
	@RequestMapping("login.html")
	public ModelAndView eventoRegistro(String txtUsuario, String txtContrasenia, HttpSession session) {
		ModelAndView MV = new ModelAndView();
		
		String mensaje = "";
		
		if(txtUsuario.equals("admin") && txtContrasenia.equals("admin")) {
	        MV.setViewName("HomeAdmin");
			return MV;
		}
		
		this.usuario = this.usuarioNegocio.ReadOne(txtUsuario);
		
		if(this.usuarioNegocio.Exist(txtUsuario) && this.usuario.getEstado()){
			this.usuario = this.usuarioNegocio.ReadOne(txtUsuario);
			if(this.usuario.getContrasenia().equals(txtContrasenia)) {
		        MV.setViewName("redirect:homeUsuario.html");
		        MV.addObject("Usuario", this.usuario);
		        session.setAttribute("sessUsuario", this.usuario);

				return MV;

			}
			else {
				mensaje = "Contrasenia incorrecta";
			}
		}
		else {
			mensaje = "El usuario ingresado no existe o fue dado de baja";
		}
		
		
        MV.addObject("mensaje", mensaje);
        MV.setViewName("Login");
		return MV;
	}
	
	
}
