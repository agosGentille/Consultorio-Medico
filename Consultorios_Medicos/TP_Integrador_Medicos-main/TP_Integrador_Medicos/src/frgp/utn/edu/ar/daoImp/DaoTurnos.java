package frgp.utn.edu.ar.daoImp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import frgp.utn.edu.ar.dao.IdaoTurnos;
import frgp.utn.edu.ar.entidades.Medico;
import frgp.utn.edu.ar.entidades.Turno;
import frgp.utn.edu.ar.entidades.Usuario;

public class DaoTurnos implements IdaoTurnos {

    private static ConfigHibernate ch;

    public DaoTurnos() {
        super();
    }

    public DaoTurnos(ConfigHibernate conexion) {
        super();
        this.ch = conexion;
    }

    public ConfigHibernate getConexion() {
        return ch;
    }

    public void setConexion(ConfigHibernate conexion) {
        this.ch = conexion;
    }

    public boolean AddTurno(Turno turno) {
		boolean isSuccess = false;
        Session session = null;
        try {
            session = ch.abrirConexion();
            session.beginTransaction();
            session.save(turno);
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

    public Turno ReadOneTurno(int id) {
        Turno turno = null;
        Session session = null;
        try {
            session = ch.abrirConexion();
            session.beginTransaction();
            turno = (Turno) session.get(Turno.class, id);
        } catch (Exception e) {
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return turno;
    }

    public void UpdateTurno(Turno turno) {
        Session session = null;
        try {
            session = ch.abrirConexion();
            session.beginTransaction();
            session.update(turno);
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

    public void DeleteTurno(Turno turno) {
        Session session = null;
        try {
            session = ch.abrirConexion();
            session.beginTransaction();
            session.delete(turno);
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

    public List<Turno> ReadAllTurnos() {
        List<Turno> turnos = null;
        Session session = null;
        try {
            session = ch.abrirConexion();
            session.beginTransaction();
            Query query = session.createQuery("FROM Turno");
            turnos = query.list();
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
        return turnos;
    }
    
    public List<Turno> ReadAllTurnosUnMedico(int legajo) {
        List<Turno> turnos = null;
        Session session = null;
        try {
			session = ch.abrirConexion();
			session.beginTransaction();
			Query hqlQuery = session.createQuery("FROM Turno WHERE legajo = :query");
			hqlQuery.setParameter("query",  legajo);
			turnos = hqlQuery.list();
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
        return turnos;
    }
    
    public List<Turno> obtenerTurnosPorMedicoYFecha(int legajo, LocalDate fecha) {
        List<Turno> turnos = null;
        Session session = null;
        try {
            session = ch.abrirConexion();
            session.beginTransaction();
            
            // Ajustar la consulta HQL para filtrar por legajo y fecha
            Query hqlQuery = session.createQuery("FROM Turno WHERE legajo = :legajo AND fecha = :fecha");
            hqlQuery.setParameter("legajo", legajo);
            hqlQuery.setParameter("fecha", fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            
            turnos = hqlQuery.list();
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
        return turnos;
    }
    

    public String MostrarPorcentajeTurnos(int legajo, LocalDate fechaIni, LocalDate fechaFin) {
        String mensaje="";
    	Session session = null;
    	String inicio = fechaIni.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    	String fin = fechaFin.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    	System.out.println("inicio"+inicio+" fin "+ fin + " legajo " + legajo);
    	
        try {
            session = ch.abrirConexion();
            session.beginTransaction();
            
            Long cantPresentes = ObtenerPresentes(session, legajo, inicio, fin);
            Long cantAusentes = ObtenerAusentes(session, legajo, inicio, fin);
            Long total = cantPresentes + cantAusentes;
            
            
            if (total > 0) {
                mensaje = "Porcentajes de turnos Presentes: " + ConvertirEnPorcentaje(cantPresentes, total) + "% y Ausentes: "
                        + ConvertirEnPorcentaje(cantAusentes, total) + "%";
            } else {
            	mensaje = "No hay turnos ni ausentes ni presentes para el período especificado.";
            }
            
            session.getTransaction().commit();
            
        } catch (Exception e) {
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
                e.printStackTrace(); 
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return mensaje;
    }

    private static Long ObtenerAusentes(Session session, int legajo, String inicio, String fin) {
        return (Long) session.createQuery(
                "SELECT COUNT(tur.estadoTurno) " +
                "FROM Turno tur " +
                "WHERE tur.estadoTurno = 'Ausente' " +
                "AND tur.medico.legajo = :legajo " +
                "AND STR_TO_DATE(tur.fecha, '%d/%m/%Y') BETWEEN STR_TO_DATE(:inicio, '%d/%m/%Y') AND STR_TO_DATE(:fin, '%d/%m/%Y')"
        )
        .setParameter("legajo", legajo)
        .setParameter("inicio", inicio)
        .setParameter("fin", fin)
        .uniqueResult();
    }

    private static Long ObtenerPresentes(Session session, int legajo, String inicio, String fin) {      
        return (Long) session.createQuery(
                "SELECT COUNT(tur.estadoTurno) " +
                "FROM Turno tur " +
                "WHERE tur.estadoTurno = 'Presente' " +
                "AND tur.medico.legajo = :legajo " +
                "AND STR_TO_DATE(tur.fecha, '%d/%m/%Y') BETWEEN STR_TO_DATE(:inicio, '%d/%m/%Y') AND STR_TO_DATE(:fin, '%d/%m/%Y')"
        )
        .setParameter("legajo", legajo)
        .setParameter("inicio", inicio)
        .setParameter("fin", fin)
        .uniqueResult();
    }

    private static long ConvertirEnPorcentaje(Long cantPresentes, Long total) {
        return (cantPresentes * 100) / total;
    }
    
    public boolean Exist(int id) {
        boolean existe = false;
        Session session = null;
        try {
            session = ch.abrirConexion();
            session.beginTransaction();
            Turno turno = (Turno) session.get(Turno.class, id);
            existe = (turno != null);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return existe;
    }
    

    public List<Turno> obtenerTurnosPorMedicoYRangoFechas(int legajo, LocalDate fechaInicio, LocalDate fechaFin) {
        List<Turno> turnos = null;
        Session session = null;
        
        try {
            session = ch.abrirConexion();
            session.beginTransaction();
            
            // Convertir fechas a formato dd/MM/yyyy
            String fechaInicioStr = fechaInicio.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            String fechaFinStr = fechaFin.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            
            // Ajustar la consulta HQL para filtrar por legajo y rango de fechas
            Query hqlQuery = session.createQuery("FROM Turno WHERE legajo = :legajo AND STR_TO_DATE(fecha, '%d/%m/%Y') "
            		+ "BETWEEN STR_TO_DATE(:fechaInicio, '%d/%m/%Y') AND STR_TO_DATE(:fechaFin, '%d/%m/%Y')");
            hqlQuery.setParameter("legajo", legajo);
            hqlQuery.setParameter("fechaInicio", fechaInicioStr);
            hqlQuery.setParameter("fechaFin", fechaFinStr);
            
            turnos = hqlQuery.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return turnos;
    }
    
    public List<Turno> findPaginated(int page, int size, int legajo) {
        Session session = null;
        try {
            session = ch.abrirConexion();
            session.beginTransaction();
            Query query = session.createQuery("FROM Turno WHERE legajo = :query");
			query.setParameter("query",  legajo);
            query.setFirstResult(page * size);
            query.setMaxResults(size);
            List<Turno> Turnos = query.list();
            session.getTransaction().commit();
            return Turnos;
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

    public long count(int legajo) {
        Session session = null;
        try {
            session = ch.abrirConexion();
            session.beginTransaction();
            Query query = session.createQuery("SELECT COUNT(t) FROM Turno t WHERE legajo = :query");
            query.setParameter("query", legajo);
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
