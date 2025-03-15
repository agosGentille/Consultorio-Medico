package frgp.utn.edu.ar.daoImp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import frgp.utn.edu.ar.dao.IdaoMedico;
import frgp.utn.edu.ar.entidades.Medico;
import frgp.utn.edu.ar.entidades.Turno;

public class daoMedico implements IdaoMedico {

    private ConfigHibernate conexion;

    public daoMedico() {
        super();
    }

    public daoMedico(ConfigHibernate conexion) {
        super();
        this.conexion = conexion;
    }

    public ConfigHibernate getConexion() {
        return conexion;
    }

    public void setConexion(ConfigHibernate conexion) {
        this.conexion = conexion;
    }

    public boolean Add(Medico medico) {
        boolean isSuccess = false;
        Session session = null;
        try {
            session = conexion.abrirConexion();
            session.beginTransaction();
            session.save(medico);
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

    public Medico ReadOne(int legajo) {
        Medico medico = null;
        Session session = null;
        try {
            session = conexion.abrirConexion();
            session.beginTransaction();
            medico = (Medico) session.get(Medico.class, legajo);
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
        return medico;
    }
    
    public Medico ReadOneConUsuario(String nombreUsuario) {
    	Medico medico = null;
        Session session = null;
        try {
            session = conexion.abrirConexion();
            session.beginTransaction();
            Query hqlQuery = session.createQuery("FROM Medico m WHERE m.usuario.nombre_usuario = :nombreUsuario");
            hqlQuery.setParameter("nombreUsuario", nombreUsuario);
            medico = (Medico) hqlQuery.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace(); // Para depuración
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return medico;
    }

    public boolean Update(Medico medico) {
        boolean isSuccess = false;
        Session session = null;
        try {
            session = conexion.abrirConexion();
            session.beginTransaction();
            session.update(medico);
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

    public void Delete(Medico medico) {
        Session session = null;
        try {
            session = conexion.abrirConexion();
            session.beginTransaction();
            session.delete(medico);
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

    public List<Medico> ReadAll() {
        List<Medico> medicos = null;
        Session session = null;
        try {
            session = conexion.abrirConexion();
            session.beginTransaction();
            Query query = session.createQuery("FROM Medico");
            medicos = query.list();
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
        return medicos;
    }
    
    public List<Medico> ReadAllDisponibles() {
    	List<Medico> medicos = new ArrayList<>();
		Session session = null;
		try {
			session = conexion.abrirConexion();
			session.beginTransaction();
			Query hqlQuery = session.createQuery("FROM Medico WHERE estado = 1");
			medicos = hqlQuery.list();
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
		return medicos;
    }
    
    public List<Medico> ReadAllXEspecialidad(int especialidad) {
    	List<Medico> medicos = new ArrayList<>();
		Session session = null;
		try {
			session = conexion.abrirConexion();
			session.beginTransaction();
			Query hqlQuery = session.createQuery("FROM Medico m WHERE m.estado = 1 AND m.especialidad.id = :query");
			hqlQuery.setParameter("query",  especialidad);
			medicos = hqlQuery.list();
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
		return medicos;
    }
    
    public List<Medico> FiltrarMedicoPorEstado(boolean estado) {
		List<Medico> medicos = new ArrayList<>();
		Session session = null;
		try {
			session = conexion.abrirConexion();
			session.beginTransaction();
			Query hqlQuery = session.createQuery("FROM Medico WHERE estado = :query");
			hqlQuery.setParameter("query",  estado);
			medicos = hqlQuery.list();
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
		return medicos;
	}

    public List<Medico> LeerMayorAMenorLegajo() {
        List<Medico> medicos = null;
        Session session = null;
        try {
            session = conexion.abrirConexion();
            session.beginTransaction();
            Query query = session.createQuery("FROM Medico ORDER BY legajo DESC");
            medicos = query.list();
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
        return medicos;
    }

    public List<Object[]> LeerMenorAMayorLegajo() {
        List<Object[]> medicos = null;
        Session session = null;
        try {
            session = conexion.abrirConexion();
            session.beginTransaction();
            Query query = session.createQuery("SELECT m.legajo, m.nombre, m.apellido FROM Medico m ORDER BY m.legajo ASC");
            medicos = query.list();
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
        return medicos;
    }

    public void Leer_ColumnaLegajo() {
        Session session = null;
        try {
            session = conexion.abrirConexion();
            session.beginTransaction();
            List<Integer> listaMedicos = session.createQuery("SELECT m.legajo FROM Medico m").list();
            System.out.println("------- 4. LISTA DE Legajos de Medicos -------");
            for (Integer legajo : listaMedicos) {
                System.out.println(legajo);
            }
            System.out.println("------- FIN LISTA DE Legajos de Medicos -------\n");
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

    public void LeerMayorLegajo() {
        Session session = null;
        try {
            session = conexion.abrirConexion();
            session.beginTransaction();
            Integer maximo = (Integer) session.createQuery("SELECT MAX(med.legajo) FROM Medico med").uniqueResult();
            System.out.println("N�mero m�ximo de legajo: " + maximo);
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

    public int traerProximoLegajo() {
        Session session = null;
        try {
            session = conexion.abrirConexion();
            session.beginTransaction();
            Integer maxLegajo = (Integer) session.createQuery("SELECT MAX(med.legajo) FROM Medico med").uniqueResult();
            session.getTransaction().commit();
            return maxLegajo != null ? maxLegajo + 1 : 1;
        } catch (Exception e) {
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            } 
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
            return 0; // Manejo de error, retorna 0 en caso de falla
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void ReadInnerJoinTurnos(int legajo, String fecha) {
        Session session = null;
        try {
            session = conexion.abrirConexion();
            session.beginTransaction();
            List<Object[]> ListaMedicosTurnos = session.createQuery("SELECT tur, tur.medico FROM Turno tur JOIN tur.medico").list();

            int cont = 0;

            for (Object[] obj : ListaMedicosTurnos) {
                Turno turno = (Turno) obj[0];
                Medico medico = (Medico) obj[1];

                if (medico.getLegajo() == legajo) {
                    cont++;
                    if (cont == 1) {
                        System.out.println("Medico= " + medico.getLegajo() + " " + medico.getApellido() + ", "
                                + medico.getNombre() + "\n\t Turnos asignados para el " + fecha + ": \n");
                    }
                }

                if (medico.getLegajo() == legajo && fecha.compareTo(turno.getFecha()) == 0) {
                    System.out.println("\t Fecha turno: " + turno.getFecha() + "\tPaciente: "
                            + (turno.getPaciente() != null ? turno.getPaciente().getNombre() : "Sin asignar") + "\n");
                }
            }

            session.getTransaction().commit();
        } catch (Exception e) {
        	e.printStackTrace();
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<Medico> BusquedaDinamicaMedicosXNombre(String nombre) {
        List<Medico> medicos = new ArrayList<>();
        Session session = null;
        try {
            session = conexion.abrirConexion();
            session.beginTransaction();
            Query hqlQuery = session.createQuery("FROM Medico WHERE nombre LIKE :query OR apellido LIKE :query ORDER BY nombre DESC");
            hqlQuery.setParameter("query", "%" + nombre + "%");
            hqlQuery.setMaxResults(5);
            medicos = hqlQuery.list();
            session.getTransaction().commit();
        } catch (Exception e) {
        	e.printStackTrace();
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return medicos;
    }

    public List<Medico> findPaginated(int page, int size) {
        Session session = null;
        try {
            session = conexion.abrirConexion();
            session.beginTransaction();
            Query query = session.createQuery("FROM Medico");
            query.setFirstResult(page * size);
            query.setMaxResults(size);
            List<Medico> medicos = query.list();
            session.getTransaction().commit();
            return medicos;
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
            Query query = session.createQuery("SELECT COUNT(m) FROM Medico m" );
            
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
    
    public List<Medico> findPaginatedConFiltro(int page, int size, boolean estado) {
        Session session = null;
        try {
            session = conexion.abrirConexion();
            session.beginTransaction();
            Query query = session.createQuery("FROM Medico WHERE estado = :estado");
            query.setParameter("estado", estado);
            query.setFirstResult(page * size);
            query.setMaxResults(size);
            List<Medico> medicos = query.list();
            session.getTransaction().commit();
            return medicos;
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
            Query query = session.createQuery("SELECT COUNT(m) FROM Medico m WHERE estado = :estado");
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
    
    public List<Medico> findPaginatedBusqueda(int page, int size, String nombre) {
        Session session = null;
        try {
            session = conexion.abrirConexion();
            session.beginTransaction();
            Query query = session.createQuery("FROM Medico WHERE nombre LIKE :query OR apellido LIKE :query ORDER BY nombre DESC");
            query.setParameter("query", "%" + nombre + "%");
            query.setFirstResult(page * size);
            query.setMaxResults(size);
            List<Medico> medicos = query.list();
            session.getTransaction().commit();
            return medicos;
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
            Query query = session.createQuery("SELECT COUNT(m) FROM Medico m WHERE m.nombre LIKE :query OR m.apellido LIKE :query ORDER BY nombre DESC");
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
