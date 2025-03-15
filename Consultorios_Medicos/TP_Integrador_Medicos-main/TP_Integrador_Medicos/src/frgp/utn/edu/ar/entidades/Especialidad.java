package frgp.utn.edu.ar.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Especialidad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    private String nombre;
    private Boolean estado;

    public Especialidad() {
    }

    public Especialidad(Integer id, String nombre, Boolean estado) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Especialidad(Integer id, String nombre) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.estado = true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Especialidad [id=" + id + ", nombre=" + nombre + "]";
    }
}
