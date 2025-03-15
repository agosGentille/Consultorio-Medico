package frgp.utn.edu.ar.controller;

import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import frgp.utn.edu.ar.entidades.Medico;
import frgp.utn.edu.ar.entidades.Turno;
import frgp.utn.edu.ar.entidades.Usuario;
import frgp.utn.edu.ar.negocioImp.EspecialidadNegocio;
import frgp.utn.edu.ar.negocioImp.MedicoNegocio;
import frgp.utn.edu.ar.negocioImp.TurnosNegocio;
import frgp.utn.edu.ar.negocioImp.UsuarioNegocio;

@Controller
public class ControladorInformes {

	@Autowired
    private TurnosNegocio turnoNegocio;
    
    @Autowired
    private Turno turno;
    
	@Autowired
    private MedicoNegocio medicoNegocio;
	
    @Autowired
    private Medico medico;

    public void init(ServletConfig config) {
    	
    	ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
    	
		this.medicoNegocio = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
		this.medico = (Medico) appContext.getBean("beanMedico");
		this.turnoNegocio = (TurnosNegocio) appContext.getBean("beanTurnosNegocio");
		this.turno = (Turno) appContext.getBean("beanTurno");
	}
    

    @RequestMapping("informes.html")
    public ModelAndView informesForm() {
        ModelAndView MV = new ModelAndView();
        MV.setViewName("Informes");
        return MV;
    }
    
    @RequestMapping(value = "buscarMedicoPorLegajo.html", method = RequestMethod.GET)
    public ModelAndView buscarMedicoPorLegajo(@RequestParam("intLegajo") int legajo, 
    		@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate sdate,
    		@RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fdate) {
   
    	ModelAndView MV = new ModelAndView();
    	
        Medico medico = medicoNegocio.ReadOne(legajo);
        if (medico != null) { 
        	MV.addObject("medico", medico);
        	MV.addObject("mensaje", "Medico: " + medico.getLegajo() + " - " + medico.getApellido() + ", " + medico.getNombre() + ".");
        } else {
        	MV.addObject("mensaje", "Por favor, ingrese el legajo de un medico existente");
        }
        
        
        if (medico!= null & sdate!=null & fdate!=null) {
        	
        	List <Turno> turnos = turnoNegocio.obtenerTurnosPorMedicoYRangoFechas(legajo, sdate, fdate);
        	
			MV.addObject("turnos", turnos);
	        MV.addObject("mensaje2", turnoNegocio.MostrarPorcentajeTurnos(legajo, sdate, fdate));
        	
        } else {
        	MV.addObject("mensaje2", "Por favor, ingrese datos validos. Operación Fallida");
        }
        
        MV.setViewName("Informes");
        return MV;
    }

}
