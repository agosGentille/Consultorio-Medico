package frgp.utn.edu.ar.negocioImp;

import java.util.List;

import frgp.utn.edu.ar.dao.IdaoPaciente;
import frgp.utn.edu.ar.entidades.Medico;
import frgp.utn.edu.ar.entidades.Paciente;
import frgp.utn.edu.ar.negocio.IPacienteNegocio;

public class PacienteNegocio implements IPacienteNegocio{
	
	private IdaoPaciente daoPaciente;

	// contructores
	public PacienteNegocio(IdaoPaciente daoPaciente) {
		super();
		this.daoPaciente = daoPaciente;
	}
	
	public PacienteNegocio() {
		super();
	
	}

	//getters y setters
	public IdaoPaciente getDaoPaciente() {
		return daoPaciente;
	}

	public void setDaoPaciente(IdaoPaciente daoPaciente) {
		this.daoPaciente = daoPaciente;
	}
	
	//llamadas al daoPacientes
	
	public boolean AddPaciente(Paciente paciente) {
		return daoPaciente.AddPaciente(paciente);
	}
	
	public boolean UpdatePaciente(Paciente paciente) {
		return daoPaciente.UpdatePaciente(paciente);
	}
	
	public void DeletePaciente (Paciente paciente) {
		daoPaciente.DeletePaciente(paciente);
	}
	
	public List<Paciente> ReadAllPacientes(){
		return daoPaciente.ReadAllPacientes();
	}
	
	public Paciente ReadOnePaciente(int dni) {
		return daoPaciente.ReadOnePaciente(dni);
	}
	
	public List<Paciente> BusquedaDinamicaPacientesXNombre(String nombre) {
		return daoPaciente.BusquedaDinamicaPacientesXNombre(nombre);
	}
	
	public List<Paciente> FiltrarPacientePorEstado(boolean estado){
		return daoPaciente.FiltrarPacientePorEstado(estado);
	}
	
	public List<Paciente> ReadAllPacientesDisponibles(){
		return daoPaciente.ReadAllPacientesDisponibles();
	}
	public List<Paciente> findPaginated(int page, int size){
		return daoPaciente.findPaginated(page, size);
	}
	public long count() {
		return daoPaciente.count();
	}
	
	public List<Paciente> findPaginatedBusqueda(int page, int size, String nombre){
		return daoPaciente.findPaginatedBusqueda(page, size, nombre);
	}
	public long countBusqueda(String nombre) {
		return daoPaciente.countBusqueda(nombre);
	}
	public List<Paciente> findPaginatedConFiltro(int page, int size, boolean estado){
		return daoPaciente.findPaginatedConFiltro(page, size, estado);
	}
	public long countConFiltro(boolean estado) {
		return daoPaciente.countConFiltro(estado);
	}
	
}
