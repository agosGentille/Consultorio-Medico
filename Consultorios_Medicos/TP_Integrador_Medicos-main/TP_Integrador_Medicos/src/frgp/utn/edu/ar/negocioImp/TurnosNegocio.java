package frgp.utn.edu.ar.negocioImp;

import java.time.LocalDate;
import java.util.List;

import frgp.utn.edu.ar.dao.IdaoTurnos;
import frgp.utn.edu.ar.entidades.Medico;
import frgp.utn.edu.ar.entidades.Turno;
import frgp.utn.edu.ar.negocio.ITurnosNegocio;

public class TurnosNegocio implements ITurnosNegocio {
	
	private IdaoTurnos dao;
	
	public TurnosNegocio() {
		super();
	}
	
	public TurnosNegocio(IdaoTurnos daoTurno) {
		super();
		this.dao = daoTurno;
	}

	public boolean AddTurno(Turno turno) {
		return dao.AddTurno(turno);
	}

	public IdaoTurnos getDao() {
		return dao;
	}

	public void setDao(IdaoTurnos dao) {
		this.dao = dao;
	}

	public void UpdateTurno(Turno turno) {
		dao.UpdateTurno(turno);
		
	}

	public void DeleteTurno(Turno turno) {
		dao.DeleteTurno(turno);
		
	}

	public Turno ReadOneTurno(int legajo) {
		return dao.ReadOneTurno(legajo);
	}

	public List<Turno> ReadAllTurnos() {
		return dao.ReadAllTurnos();
	}

	public String MostrarPorcentajeTurnos(int legajo, LocalDate fechaIni, LocalDate fechaFin) {
		return dao.MostrarPorcentajeTurnos(legajo, fechaIni, fechaFin);	
	}
	
	public List<Turno> ReadAllTurnosUnMedico(int legajo){
		return dao.ReadAllTurnosUnMedico(legajo);
	}
	
	public boolean Exist(int id) {
		return dao.Exist(id);
	}
	
	public List<Turno> obtenerTurnosPorMedicoYFecha(int legajo, LocalDate fecha){
		return dao.obtenerTurnosPorMedicoYFecha(legajo, fecha);
	}
	
	public List<Turno> obtenerTurnosPorMedicoYRangoFechas(int legajo, LocalDate fechaInicio, LocalDate fechaFin){
		return dao.obtenerTurnosPorMedicoYRangoFechas(legajo, fechaInicio, fechaFin);
	}
	
	public List<Turno> findPaginated(int page, int size, int legajo){
		return dao.findPaginated(page, size, legajo);
	}
	public long count(int legajo) {
		return dao.count(legajo);
	}

}
