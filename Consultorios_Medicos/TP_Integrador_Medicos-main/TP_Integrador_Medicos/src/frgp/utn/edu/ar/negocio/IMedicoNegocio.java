package frgp.utn.edu.ar.negocio;

import java.util.List;

import frgp.utn.edu.ar.entidades.Medico;

public interface IMedicoNegocio {
	
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
	public List<Medico> BusquedaDinamicaMedicosXNombre(String nombre);
    public List<Medico> findPaginatedConFiltro(int page, int size, boolean estado);
    public long countConFiltro(boolean estado);
    public List<Medico> FiltrarMedicoPorEstado(boolean estado);
    public Medico ReadOneConUsuario(String usuario);
    
}
