package frgp.utn.edu.ar.dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;

import frgp.utn.edu.ar.entidades.Medico;
import frgp.utn.edu.ar.entidades.Turno;
public interface IdaoTurnos {
	
	public boolean AddTurno(Turno turno);
	public void UpdateTurno(Turno turno);
	public void DeleteTurno(Turno turno);
	public Turno ReadOneTurno(int legajo);
	public List<Turno> ReadAllTurnos();
	public String MostrarPorcentajeTurnos(int legajo, LocalDate fechaIni, LocalDate fechaFin);
	public List<Turno> ReadAllTurnosUnMedico(int legajo);
	public boolean Exist(int id);
	public List<Turno> obtenerTurnosPorMedicoYFecha(int legajo, LocalDate fecha);
	public List<Turno> obtenerTurnosPorMedicoYRangoFechas(int legajo, LocalDate fechaInicio, LocalDate fechaFin);
	public List<Turno> findPaginated(int page, int size, int legajo);
	public long count(int legajo);
}

