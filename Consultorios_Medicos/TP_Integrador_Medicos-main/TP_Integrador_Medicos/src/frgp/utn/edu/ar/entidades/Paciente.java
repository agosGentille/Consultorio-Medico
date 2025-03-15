package frgp.utn.edu.ar.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Paciente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int DNI;
	private String nombre;
	private String apellido;
	private int telefono;
	private String direccion;
	private String localidad;
	private String provincia;
	private String fechaNac;
	private String correo;
	private Boolean estado;
	
	public Paciente() {
		super();
	}
	
	public Paciente(int dNI, String nombre, String apellido, int telefono, String direccion, String localidad,
			String provincia, String fechaNac, String correo, Boolean estado) {
		super();
		DNI = dNI;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.direccion = direccion;
		this.localidad = localidad;
		this.provincia = provincia;
		this.fechaNac = fechaNac;
		this.correo = correo;
		this.estado = estado;
	}
	
	public Paciente(int dNI, String nombre, String apellido, int telefono, String direccion, String localidad,
			String provincia, String fechaNac, String correo) {
		super();
		DNI = dNI;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.direccion = direccion;
		this.localidad = localidad;
		this.provincia = provincia;
		this.fechaNac = fechaNac;
		this.correo = correo;
		this.estado = true;
	}

	public Boolean setEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getDNI() {
		return DNI;
	}
	public void setDNI(int dNI) {
		DNI = dNI;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	

	public Boolean getEstado() {
		return estado;
	}

	@Override
	public String toString() {
		return "Paciente [DNI=" + DNI + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono
				+ ", direccion=" + direccion + ", localidad=" + localidad + ", provincia=" + provincia + ", fechaNac="
				+ fechaNac + ", correo=" + correo + "]";
	}

}
