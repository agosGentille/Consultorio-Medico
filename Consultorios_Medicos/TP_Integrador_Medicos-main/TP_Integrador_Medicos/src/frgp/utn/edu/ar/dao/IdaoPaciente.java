package frgp.utn.edu.ar.dao;

import java.util.List;

import frgp.utn.edu.ar.entidades.Medico;
import frgp.utn.edu.ar.entidades.Paciente;

public interface IdaoPaciente {
	
	public boolean AddPaciente(Paciente paciente);
	public boolean UpdatePaciente(Paciente paciente);
	public void DeletePaciente (Paciente paciente);
	public List<Paciente> ReadAllPacientes();
	public Paciente ReadOnePaciente(int dni);
	public List<Paciente> BusquedaDinamicaPacientesXNombre(String nombre);
	public List<Paciente> FiltrarPacientePorEstado(boolean estado);
	public List<Paciente> ReadAllPacientesDisponibles();
	public List<Paciente> findPaginated(int page, int size);
	public long count();
	public List<Paciente> findPaginatedBusqueda(int page, int size, String nombre);
	public long countBusqueda(String nombre);
	public List<Paciente> findPaginatedConFiltro(int page, int size, boolean estado);
	public long countConFiltro(boolean estado);
	
}
