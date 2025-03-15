package frgp.utn.edu.ar.entidades;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Turno implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	private String fecha;
	private String hora;
	private String observaciones;
	private String estadoTurno;
	private Boolean estadoRegistro;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="legajo")
	private Medico medico;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="DNI")
	private Paciente paciente;
	
	//constructor
	public Turno() {
		super();
	}
	
	public Turno(int id, Medico medico, Paciente paciente, String fecha, String hora,
			String observaciones, String estadoTurno, Boolean estadoRegistro) {
		super();
		this.id = id;
		this.medico = medico;
		this.paciente = paciente;
		this.fecha = fecha;
		this.hora = hora;
		this.observaciones = observaciones;
		this.estadoTurno = estadoTurno;
		this.estadoRegistro = estadoRegistro;
	}
	
	public Turno(int id, Medico medico, Paciente paciente, String fecha, String hora,
			String observaciones, String estadoTurno) {
		super();
		this.id = id;
		this.medico = medico;
		this.paciente = paciente;
		this.fecha = fecha;
		this.hora = hora;
		this.observaciones = observaciones;
		this.estadoTurno = estadoTurno;
		this.estadoRegistro = true;
	}
	

	//gets y sets
	public int getId() {
		return id;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getEstadoTurno() {
		return estadoTurno;
	}

	public void setEstadoTurno(String estadoTurno) {
		this.estadoTurno = estadoTurno;
	}

	public Boolean getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(Boolean estado) {
		this.estadoRegistro = estado;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Turno [id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", observaciones=" + observaciones
				+ ", estadoTurno=" + estadoTurno + ", medico=" + medico.getLegajo() + ", paciente=" + paciente.getDNI() + "]";
	}
		
}
