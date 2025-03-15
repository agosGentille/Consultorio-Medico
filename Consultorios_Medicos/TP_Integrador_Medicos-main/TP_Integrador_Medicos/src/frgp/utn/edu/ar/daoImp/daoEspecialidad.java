package frgp.utn.edu.ar.daoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import frgp.utn.edu.ar.dao.IdaoEspecialidad;
import frgp.utn.edu.ar.entidades.Especialidad;

public class daoEspecialidad implements IdaoEspecialidad {

    private ConfigHibernate conexion;

    public daoEspecialidad() {
        super();
    }

    public daoEspecialidad(ConfigHibernate conexion) {
        super();
        this.conexion = conexion;
    }

    public ConfigHibernate getConexion() {
        return conexion;
    }

    public void setConexion(ConfigHibernate conexion) {
        this.conexion = conexion;
    }

    public boolean addEspecialidad(Especialidad especialidad) {
        Session session = null;
        try {
            session = conexion.abrirConexion();
            session.beginTransaction();
   
            Integer ultimoId = (Integer) session.createQuery("SELECT MAX(id) FROM Especialidad").uniqueResult();
            especialidad.setId(ultimoId != null ? ultimoId + 1 : 1);
            
            session.save(especialidad);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (session != null && session.getTransaction() != null) {
            	e.printStackTrace();
                session.getTransaction().rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Especialidad getEspecialidadById(int id) {
        Especialidad especialidad = null;
        Session session = null;
        try {
            session = conexion.abrirConexion();
            session.beginTransaction();
            especialidad = (Especialidad) session.get(Especialidad.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return especialidad;
    }

    public boolean updateEspecialidad(Especialidad especialidad) {
        Session session = null;
        try {
            session = conexion.abrirConexion();
            session.beginTransaction();
            session.update(especialidad);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
                e.printStackTrace();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public boolean deleteEspecialidad(Especialidad especialidad) {
        Session session = null;
        try {
            session = conexion.abrirConexion();
            session.beginTransaction();
            session.delete(especialidad);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (session != null && session.getTransaction() != null) {
                e.printStackTrace();
                session.getTransaction().rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<Especialidad> getAllEspecialidades() {
        List<Especialidad> especialidades = null;
        Session session = null;
        try {
            session = conexion.abrirConexion();
            session.beginTransaction();
            especialidades = session.createCriteria(Especialidad.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return especialidades;
    }
    
    public boolean isEspecialidadEnUso(int id) {
        Session session = null;
        try {
            session = conexion.abrirConexion();
            session.beginTransaction();

            Query query = session.createQuery("SELECT COUNT(*) FROM Medico WHERE especialidad_med = :id");
            query.setParameter("id", id);
            Long count = (Long) query.uniqueResult();
            session.getTransaction().commit();
            return count > 0;
        } catch (Exception e) {
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public boolean isEspecialidadDuplicada(String nombre) {
        Session session = null;
        try {
            session = conexion.abrirConexion();
            session.beginTransaction();
            Query query = session.createQuery("SELECT COUNT(*) FROM Especialidad WHERE nombre = :nombre");
            query.setParameter("nombre", nombre);
            Long count = (Long) query.uniqueResult();
            session.getTransaction().commit();
            return count > 0;
        } catch (Exception e) {
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
