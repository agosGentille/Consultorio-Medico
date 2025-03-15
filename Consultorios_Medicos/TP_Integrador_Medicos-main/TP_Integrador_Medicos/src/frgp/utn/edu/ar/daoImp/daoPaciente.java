package frgp.utn.edu.ar.daoImp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import frgp.utn.edu.ar.dao.IdaoPaciente;
import frgp.utn.edu.ar.entidades.Medico;
import frgp.utn.edu.ar.entidades.Paciente;

public class daoPaciente implements IdaoPaciente {
	
	private ConfigHibernate conexion;

	public void setConexion(ConfigHibernate conexion) {
		this.conexion = conexion;
	}
	
	public boolean AddPaciente(Paciente paciente) {
		boolean isSuccess = false;
		Session session = null;
		try {
			session = conexion.abrirConexion();
			session.beginTransaction();
			session.save(paciente);
			session.getTransaction().commit();
			isSuccess = true;
		} catch (Exception e) {
			if (session != null && session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return isSuccess;
	}
	
	public Paciente ReadOnePaciente(int dni) {
		Paciente paciente = null;
		Session session = null;
		try {
			session = conexion.abrirConexion();
			session.beginTransaction();
			paciente = (Paciente) session.get(Paciente.class, dni);
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
		return paciente;
	}
	
	public boolean UpdatePaciente(Paciente paciente) {
		boolean isSuccess = false;
		Session session = null;
		try {
			session = conexion.abrirConexion();
			session.beginTransaction();
			session.update(paciente);
			session.getTransaction().commit();
			isSuccess = true;
		} catch (Exception e) {
			if (session != null && session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return isSuccess;
	}
	
	public void DeletePaciente(Paciente paciente) {
		Session session = null;
		try {
			session = conexion.abrirConexion();
			session.beginTransaction();
			session.delete(paciente);
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
	}
	
	public List<Paciente> ReadAllPacientes() {
		List<Paciente> pacientes = new ArrayList<>();
		Session session = null;
		try {
			session = conexion.abrirConexion();
			session.beginTransaction();
			pacientes = session.createCriteria(Paciente.class).list();
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
		return pacientes;
	}
	
	public List<Paciente> ReadAllPacientesDisponibles() {
		List<Paciente> pacientes = new ArrayList<>();
		Session session = null;
		try {
			session = conexion.abrirConexion();
			session.beginTransaction();
			Query hqlQuery = session.createQuery("FROM Paciente WHERE estado = 1");
			pacientes = hqlQuery.list();
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
		return pacientes;
	}

	public List<Paciente> BusquedaDinamicaPacientesXNombre(String nombre) {
		List<Paciente> pacientes = new ArrayList<>();
		Session session = null;
		try {
			session = conexion.abrirConexion();
			session.beginTransaction();
			Query hqlQuery = session.createQuery("FROM Paciente WHERE nombre LIKE :query OR apellido LIKE :query");
			hqlQuery.setParameter("query", "%" + nombre + "%");
			pacientes = hqlQuery.list();
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
		return pacientes;
	}
	
	public List<Paciente> FiltrarPacientePorEstado(boolean estado) {
		List<Paciente> pacientes = new ArrayList<>();
		Session session = null;
		try {
			session = conexion.abrirConexion();
			session.beginTransaction();
			Query hqlQuery = session.createQuery("FROM Paciente WHERE estado LIKE :query");
			hqlQuery.setParameter("query",  estado);
			pacientes = hqlQuery.list();
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
		return pacientes;
	}
	
	public List<Paciente> findPaginated(int page, int size) {
        Session session = null;
        try {
            session = conexion.abrirConexion();
            session.beginTransaction();
            Query query = session.createQuery("FROM Paciente");
            query.setFirstResult(page * size);
            query.setMaxResults(size);
            List<Paciente> pacientes = query.list();
            session.getTransaction().commit();
            return pacientes;
        } catch (Exception e) {
        	e.printStackTrace();
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            return new ArrayList<>();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
	
	public long count() {
        Session session = null;
        try {
            session = conexion.abrirConexion();
            session.beginTransaction();
            Query query = session.createQuery("SELECT COUNT(p) FROM Paciente p ");
            long count = (Long) query.uniqueResult();
            session.getTransaction().commit();
            return count;
        } catch (Exception e) {
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            return 0;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
	
	public List<Paciente> findPaginatedConFiltro(int page, int size, boolean estado) {
        Session session = null;
        try {
            session = conexion.abrirConexion();
            session.beginTransaction();
            Query query = session.createQuery("FROM Paciente WHERE estado = :estado");
            query.setParameter("estado", estado);
            query.setFirstResult(page * size);
            query.setMaxResults(size);
            List<Paciente> Paciente = query.list();
            session.getTransaction().commit();
            return Paciente;
        } catch (Exception e) {
        	e.printStackTrace();
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            return new ArrayList<>();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
	
	public long countConFiltro(boolean estado) {
        Session session = null;
        try {
            session = conexion.abrirConexion();
            session.beginTransaction();
            Query query = session.createQuery("SELECT COUNT(p) FROM Paciente p WHERE p.estado=:estado");
            query.setParameter("estado", estado);
            long count = (Long) query.uniqueResult();
            session.getTransaction().commit();
            return count;
        } catch (Exception e) {
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            return 0;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
	
	public List<Paciente> findPaginatedBusqueda(int page, int size, String nombre) {
        Session session = null;
        try {
            session = conexion.abrirConexion();
            session.beginTransaction();
            Query query = session.createQuery("FROM Paciente WHERE nombre LIKE :query OR apellido LIKE :query");
            query.setParameter("query", "%" + nombre + "%");
            query.setFirstResult(page * size);
            query.setMaxResults(size);
            List<Paciente> Paciente = query.list();
            session.getTransaction().commit();
            return Paciente;
        } catch (Exception e) {
        	e.printStackTrace();
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            return new ArrayList<>();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
	
	public long countBusqueda(String nombre) {
        Session session = null;
        try {
            session = conexion.abrirConexion();
            session.beginTransaction();
            Query query = session.createQuery("SELECT COUNT(p) FROM Paciente p WHERE p.nombre LIKE :query OR p.apellido LIKE :query");
            query.setParameter("query", "%" + nombre + "%");
            long count = (Long) query.uniqueResult();
            session.getTransaction().commit();
            return count;
        } catch (Exception e) {
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            return 0;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
