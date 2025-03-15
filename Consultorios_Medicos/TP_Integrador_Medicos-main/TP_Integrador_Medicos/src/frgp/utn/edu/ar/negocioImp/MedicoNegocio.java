package frgp.utn.edu.ar.negocioImp;

import java.util.List;

import frgp.utn.edu.ar.dao.IdaoMedico;
import frgp.utn.edu.ar.entidades.Medico;
import frgp.utn.edu.ar.negocio.IMedicoNegocio;

public class MedicoNegocio implements IMedicoNegocio{

	private IdaoMedico daoMedico;

	public MedicoNegocio(IdaoMedico daoMedico) {
		super();
		this.daoMedico = daoMedico;
	}

	public MedicoNegocio() {
		super();
	}

	public IdaoMedico getDaoMedico() {
		return daoMedico;
	}

	public void setDaoMedico(IdaoMedico daoMedico) {
		this.daoMedico = daoMedico;
	}
	
	
	public boolean Add(Medico medico) {
		return daoMedico.Add(medico);
	}
	
	public boolean Update(Medico medico) {
		return daoMedico.Update(medico);
	}
	
	
	public void Delete(Medico medico) {
		daoMedico.Delete(medico);
	}
	
	public Medico ReadOneConUsuario(String usuario){
		return daoMedico.ReadOneConUsuario(usuario);
	}
	
	
	public Medico ReadOne(int legajo) {
		return daoMedico.ReadOne(legajo);
	}
	
	
	public List<Medico> ReadAll(){
		return daoMedico.ReadAll();
	}
	
	
	public List<Medico> LeerMayorAMenorLegajo(){
		return daoMedico.LeerMayorAMenorLegajo();
	}
	
	
	public List<Object[]> LeerMenorAMayorLegajo(){
		return daoMedico.LeerMenorAMayorLegajo();
	}

	
	public void Leer_ColumnaLegajo() {
		daoMedico.Leer_ColumnaLegajo();
	}
	
	
	public void LeerMayorLegajo() {
		daoMedico.LeerMayorLegajo();
	}
	
	public void ReadInnerJoinTurnos(int legajo, String fecha) {
		daoMedico.ReadInnerJoinTurnos(legajo, fecha);
	}

	public int traerProximoLegajo() {
		return daoMedico.traerProximoLegajo();
	}
	
	public List<Medico> BusquedaDinamicaMedicosXNombre(String nombre) {
		return daoMedico.BusquedaDinamicaMedicosXNombre(nombre);
	}
	
	public List<Medico> findPaginatedConFiltro(int page, int size, boolean estado) {
        return daoMedico.findPaginatedConFiltro(page, size, estado);
    }

    public long countConFiltro(boolean estado) {
        return daoMedico.countConFiltro(estado);
    }
	
    public List<Medico> FiltrarMedicoPorEstado(boolean estado){
    	return daoMedico.FiltrarMedicoPorEstado(estado);
    }
    
    public List<Medico> ReadAllDisponibles(){
    	return daoMedico.ReadAllDisponibles();
    }
    
    public List<Medico> ReadAllXEspecialidad(int especialidad){
    	return daoMedico.ReadAllXEspecialidad(especialidad);
    }
    
    public List<Medico> findPaginatedBusqueda(int page, int size, String nombre){
    	return daoMedico.findPaginatedBusqueda(page, size, nombre);
    }
    public long countBusqueda(String nombre) {
    	return daoMedico.countBusqueda(nombre);
    }
    public List<Medico> findPaginated(int page, int size){
    	return daoMedico.findPaginated(page, size);
    }
    public long count() {
    	return daoMedico.count();
    }
    
}
