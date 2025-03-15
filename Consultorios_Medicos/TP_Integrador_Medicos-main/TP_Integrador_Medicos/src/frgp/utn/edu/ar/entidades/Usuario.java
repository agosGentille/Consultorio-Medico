package frgp.utn.edu.ar.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String nombre_usuario;
	
	private String contrasenia;
	private Boolean estado;
	
	@OneToOne(mappedBy = "usuario", fetch = FetchType.EAGER)
	private Medico medico;
	
	
	public Usuario() {
		
	}
	
	public Usuario(String nombre_usuario, String contrasenia, Boolean estado, Medico medico) {
		super();
		this.nombre_usuario = nombre_usuario;
		this.contrasenia = contrasenia;
		this.estado = estado;
		this.medico = medico;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	@Override
	public String toString() {
		return "Usuario [nombre_usuario=" + nombre_usuario + ", contrasenia=" + contrasenia + ", medico=" + medico.getNombre() + "]";
	}
	
	
}
