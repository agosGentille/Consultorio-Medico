package frgp.utn.edu.ar.negocioImp;

import java.util.List;

import frgp.utn.edu.ar.dao.IdaoEspecialidad;
import frgp.utn.edu.ar.entidades.Especialidad;
import frgp.utn.edu.ar.negocio.IEspecialidadNegocio;

public class EspecialidadNegocio implements IEspecialidadNegocio{

	private IdaoEspecialidad daoEspecialidad;

	public EspecialidadNegocio(IdaoEspecialidad daoEspecialidad) {
		super();
		this.daoEspecialidad = daoEspecialidad;
	}

	public EspecialidadNegocio() {
		super();
	}

	public IdaoEspecialidad getDaoEspecialidad() {
		return daoEspecialidad;
	}

	public void setDaoEspecialidad(IdaoEspecialidad daoEspecialidad) {
		this.daoEspecialidad = daoEspecialidad;
	}
	
	
	public boolean addEspecialidad(Especialidad especialidad) {
		return daoEspecialidad.addEspecialidad(especialidad);
	}
	
	public Especialidad getEspecialidadById(int id) {
		return daoEspecialidad.getEspecialidadById(id);
	}
	
	public boolean updateEspecialidad(Especialidad especialidad) {
		return daoEspecialidad.updateEspecialidad(especialidad);
	}
	
	public boolean deleteEspecialidad(Especialidad especialidad) {
		return daoEspecialidad.deleteEspecialidad(especialidad);
	}

	public List<Especialidad> getAllEspecialidades(){
		return daoEspecialidad.getAllEspecialidades();
	}
    public boolean isEspecialidadEnUso(int id) {
        return daoEspecialidad.isEspecialidadEnUso(id);
    }

    public boolean isEspecialidadDuplicada(String nombre) {
        return daoEspecialidad.isEspecialidadDuplicada(nombre);
    }
}
