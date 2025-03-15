package frgp.utn.edu.ar.dao;

import java.util.List;

import frgp.utn.edu.ar.entidades.Medico;

public interface IdaoMedico {
	
	public boolean Add(Medico medico);
	public boolean Update(Medico medico);
	public void Delete(Medico medico);
	public Medico ReadOne(int legajo);
	public List<Medico> ReadAll();
	public List<Medico> LeerMayorAMenorLegajo();
	public List<Object[]> LeerMenorAMayorLegajo();
	public void Leer_ColumnaLegajo();
	public void LeerMayorLegajo();
	public void ReadInnerJoinTurnos(int legajo, String fecha);
	public int traerProximoLegajo();
	public List<Medico> BusquedaDinamicaMedicosXNombre(String nombre);
	public List<Medico> findPaginatedConFiltro(int page, int size, boolean estado);
    public long countConFiltro(boolean estado);
    public List<Medico> FiltrarMedicoPorEstado(boolean estado);
    public Medico ReadOneConUsuario(String usuario);
    public List<Medico> ReadAllDisponibles();
    public List<Medico> ReadAllXEspecialidad(int especialidad);
    public List<Medico> findPaginatedBusqueda(int page, int size, String nombre);
    public long countBusqueda(String nombre);
    public List<Medico> findPaginated(int page, int size);
    public long count();
}
