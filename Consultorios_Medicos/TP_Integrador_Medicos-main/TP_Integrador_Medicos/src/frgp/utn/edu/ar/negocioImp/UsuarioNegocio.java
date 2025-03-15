package frgp.utn.edu.ar.negocioImp;

import java.util.List;

import frgp.utn.edu.ar.dao.IdaoUsuario;
import frgp.utn.edu.ar.daoImp.DaoUsuario;
import frgp.utn.edu.ar.entidades.Usuario;
import frgp.utn.edu.ar.negocio.IUsuarioNegocio;

public class UsuarioNegocio implements IUsuarioNegocio {

    private IdaoUsuario dao = new DaoUsuario();

    public boolean Add(Usuario user) {
        return dao.Add(user);
    }

    public Usuario ReadOne(String nombreUsuario) {
        return dao.ReadOne(nombreUsuario);
    }

    public List<Usuario> ReadAll() {
        return dao.ReadAll();
    }

    public boolean Exist(String nombreUsuario) {
        return dao.Exist(nombreUsuario);
    }

    public boolean Update(Usuario usuario) {
        return dao.Update(usuario);
    }

    public boolean Delete(Usuario usuario) {
        return dao.Delete(usuario);
    }

    public void setDaoUsuario(DaoUsuario daoUsuario) {
        this.dao = daoUsuario;
    }
}
