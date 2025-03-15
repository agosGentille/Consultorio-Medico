package frgp.utn.edu.ar.dao;

import java.util.List;
import frgp.utn.edu.ar.entidades.Especialidad;

public interface IdaoEspecialidad {
    public boolean addEspecialidad(Especialidad especialidad);
    public Especialidad getEspecialidadById(int id);
    public boolean updateEspecialidad(Especialidad especialidad);
    public boolean deleteEspecialidad(Especialidad especialidad);
    public List<Especialidad> getAllEspecialidades();
    boolean isEspecialidadEnUso(int id);
    boolean isEspecialidadDuplicada(String nombre);
}
