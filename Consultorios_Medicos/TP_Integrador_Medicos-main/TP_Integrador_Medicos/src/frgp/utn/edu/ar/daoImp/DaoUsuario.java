package frgp.utn.edu.ar.daoImp;

import java.util.List;

import org.hibernate.Session;

import frgp.utn.edu.ar.dao.IdaoUsuario;
import frgp.utn.edu.ar.entidades.Usuario;

public class DaoUsuario implements IdaoUsuario {

    private ConfigHibernate conexion;

    public ConfigHibernate getConexion() {
        return conexion;
    }

    public void setConexion(ConfigHibernate conexion) {
        this.conexion = conexion;
    }

    public boolean Add(Usuario user) {
        boolean estado = true;
        Session session = null;
        try {
            session = conexion.abrirConexion();
            session.beginTransaction();
            session.save(user);
            session.flush();
            session.getTransaction().commit();

            Usuario savedUser = (Usuario) session.get(Usuario.class, user.getNombre_usuario());

            if (savedUser == null) {
                estado = false;
            }

        } catch (Exception e) {
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            estado = false;
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return estado;
    }

    public Usuario ReadOne(String nombreUsuario) {
        Usuario usuario = null;
        Session session = null;
        try {
            session = conexion.abrirConexion();
            session.beginTransaction();
            usuario = (Usuario) session.get(Usuario.class, nombreUsuario);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return usuario;
    }

    public List<Usuario> ReadAll() {
        List<Usuario> usuarios = null;
        Session session = null;
        try {
            session = conexion.abrirConexion();
            session.beginTransaction();
            usuarios = session.createQuery("FROM Usuario").list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return usuarios;
    }

    public boolean Exist(String nombreUsuario) {
        boolean existe = false;
        Session session = null;
        try {
            session = conexion.abrirConexion();
            session.beginTransaction();
            Usuario usuario = (Usuario) session.get(Usuario.class, nombreUsuario);
            existe = (usuario != null);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return existe;
    }

    public boolean Update(Usuario usuario) {
        boolean estado = true;
        Session session = null;
        try {
            session = conexion.abrirConexion();
            session.beginTransaction();
            session.update(usuario);
            session.flush();
            session.getTransaction().commit();

            Usuario savedUser = (Usuario) session.get(Usuario.class, usuario.getNombre_usuario());

            if (!savedUser.equals(usuario)) {
                estado = false;
            }
        } catch (Exception e) {
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            estado = false;
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return estado;
    }

    public boolean Delete(Usuario usuario) {
        boolean estado = true;
        Session session = null;
        try {
            session = conexion.abrirConexion();
            session.beginTransaction();
            session.delete(usuario);
            session.flush();
            session.getTransaction().commit();

            Usuario savedUser = (Usuario) session.get(Usuario.class, usuario.getNombre_usuario());

            if (savedUser != null) {
                estado = false;
            }
        } catch (Exception e) {
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            estado = false;
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return estado;
    }
}
