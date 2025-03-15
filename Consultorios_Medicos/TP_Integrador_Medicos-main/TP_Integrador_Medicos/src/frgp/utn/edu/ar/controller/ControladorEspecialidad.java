package frgp.utn.edu.ar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidades.Especialidad;
import frgp.utn.edu.ar.negocio.IEspecialidadNegocio;

@Controller
public class ControladorEspecialidad {

    @Autowired
    private IEspecialidadNegocio especialidadNegocio;

    @RequestMapping("altaEspecialidad.html")
    public ModelAndView altaEspecialidad() {
        ModelAndView MV = new ModelAndView();
        MV.setViewName("AltaEspecialidad");
        return MV;
    }

    @RequestMapping("bajaListaEspecialidad.html")
    public ModelAndView bajaListaEspecialidad() {
        ModelAndView MV = new ModelAndView();
        List<Especialidad> especialidades = especialidadNegocio.getAllEspecialidades();
        MV.addObject("especialidades", especialidades);
        MV.setViewName("BajaListaEspecialidad");
        return MV;
    }

    @RequestMapping("borrarEspecialidad.html")
    public ModelAndView borrarEspecialidad(int id) {
        ModelAndView MV = new ModelAndView();
        if (especialidadNegocio.isEspecialidadEnUso(id)) {
            MV.addObject("resultadoEliminar", "No se puede eliminar la especialidad porque está en uso.");
        } else {
            Especialidad aBorrar = especialidadNegocio.getEspecialidadById(id);
            boolean resultado = especialidadNegocio.deleteEspecialidad(aBorrar);
            MV.addObject("resultadoEliminar", resultado ? "Especialidad eliminada exitosamente" : "Error al eliminar especialidad");
        }
        List<Especialidad> especialidades = especialidadNegocio.getAllEspecialidades();
        MV.addObject("especialidades", especialidades);
        MV.setViewName("BajaListaEspecialidad");
        return MV;
    }

    @RequestMapping("agregarEspecialidad.html")
    public ModelAndView agregarEspecialidad(@RequestParam("nombre") String nombre) {
        ModelAndView MV = new ModelAndView();
        Especialidad especialidad = new Especialidad();
        especialidad.setNombre(nombre);
        especialidad.setEstado(true);

        if (especialidadNegocio.isEspecialidadDuplicada(nombre)) {
            MV.addObject("resultadoGuardar", "Error al guardar la especialidad. Epecialidad duplicada.");
        }else {
	        if (especialidadNegocio.addEspecialidad(especialidad)) {
	            MV.addObject("resultadoGuardar", "Especialidad guardada correctamente.");
	        } else {
	            MV.addObject("resultadoGuardar", "Error al guardar la especialidad.");
	        }
        }

        List<Especialidad> especialidades = especialidadNegocio.getAllEspecialidades();
        MV.addObject("especialidades", especialidades);
        MV.setViewName("BajaListaEspecialidad");
        return MV;
    }
}
