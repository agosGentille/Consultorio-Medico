package frgp.utn.edu.ar.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Medico implements Serializable {
		
		private static final long serialVersionUID = 1L;
		
		@Id
		//@GeneratedValue (strategy = GenerationType.IDENTITY)
		private int legajo;
		
		private String nombre;
		private String apellido;
		private char sexo;
		private String fechaNacimiento;	
		private String direccion;	
		private String localidad;		
		private String email;		
		private int telefono;
		private String diasQueTrabaja;
		private String horaEntrada;
		private String horaSalida;
		private Boolean estado;

		@OneToOne(cascade = {CascadeType.ALL})
		@JoinColumn(name="usuario_med")
		private Usuario usuario;
		
		@ManyToOne(cascade = {CascadeType.ALL})
		@JoinColumn(name="especialidad_med")
		private Especialidad especialidad;
		
		public Medico() {
			
		}

		public Medico(int legajo, String nombre, String apellido, char sexo, String fechaNacimiento, String direccion,
				String localidad, String email, int telefono, String diasQueTrabaja, String horaEntrada, String horaSalida,
				Boolean estado, Usuario usuario, Especialidad especialidad) {
			super();
			this.legajo = legajo;
			this.nombre = nombre;
			this.apellido = apellido;
			this.sexo = sexo;
			this.fechaNacimiento = fechaNacimiento;
			this.direccion = direccion;
			this.localidad = localidad;
			this.email = email;
			this.telefono = telefono;
			this.diasQueTrabaja = diasQueTrabaja;
			this.horaEntrada = horaEntrada;
			this.horaSalida = horaSalida;
			this.estado = estado;
			this.usuario = usuario;
			this.especialidad = especialidad;
		}
		
		public Medico(int legajo, String nombre, String apellido, char sexo, String fechaNacimiento, String direccion,
				String localidad, String email, int telefono, String diasQueTrabaja, String horaEntrada, String horaSalida,
				Usuario usuario, Especialidad especialidad) {
			super();
			this.legajo = legajo;
			this.nombre = nombre;
			this.apellido = apellido;
			this.sexo = sexo;
			this.fechaNacimiento = fechaNacimiento;
			this.direccion = direccion;
			this.localidad = localidad;
			this.email = email;
			this.telefono = telefono;
			this.diasQueTrabaja = diasQueTrabaja;
			this.diasQueTrabaja = diasQueTrabaja;
			this.horaEntrada = horaEntrada;
			this.estado = true;
			this.usuario = usuario;
			this.especialidad = especialidad;
		}

		public Especialidad getEspecialidad() {
			return especialidad;
		}

		public void setEspecialidad(Especialidad especialidad) {
			this.especialidad = especialidad;
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

		public void setLegajo(int legajo) {
			this.legajo = legajo;
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

		public char getSexo() {
			return sexo;
		}

		public void setSexo(char sexo) {
			this.sexo = sexo;
		}

		public String getFechaNacimiento() {
			return fechaNacimiento;
		}

		public void setFechaNacimiento(String fechaNacimiento) {
			this.fechaNacimiento = fechaNacimiento;
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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public int getTelefono() {
			return telefono;
		}

		public void setTelefono(int telefono) {
			this.telefono = telefono;
		}

		public int getLegajo() {
			return legajo;
		}
		
		public Boolean getEstado() {
			return estado;
		}

		public void setEstado(Boolean estado) {
			this.estado = estado;
		}

		public String getDiasQueTrabaja() {
			return diasQueTrabaja;
		}

		public void setDiasQueTrabaja(String diasQueTrabaja) {
			this.diasQueTrabaja = diasQueTrabaja;
		}

		public String getHoraEntrada() {
			return horaEntrada;
		}

		public void setHoraEntrada(String horaEntrada) {
			this.horaEntrada = horaEntrada;
		}

		public String getHoraSalida() {
			return horaSalida;
		}

		public void setHoraSalida(String horaSalida) {
			this.horaSalida = horaSalida;
		}

		@Override
		public String toString() {
			return "Medico: " + legajo + " - " + nombre + ", " + apellido + "\n Sexo: " + sexo
					+ "\n Fecha de Nacimiento: " + fechaNacimiento + "\n Direccion: " + direccion + ", Localidad: " + localidad
					+ "\n Contacto: \n - Email: " + email + "\n - Telefono: " + telefono + ""
					+ "\n Especialidad: " + getEspecialidad().getNombre() + " "
					+ "\n Usuario: " + usuario.getNombre_usuario() + "" 
					+ "\n\n";
		}
	
	}