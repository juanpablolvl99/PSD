package projeto.psd.interfaces;

import java.sql.SQLException;
import java.util.List;
import projeto.psd.entidades.Usuario;

public interface UsuarioDaoIf {

    public boolean add(Usuario u) throws SQLException;

    public List<Usuario> readByNome(String nome) throws SQLException;

    public boolean remove(String login, String senha) throws SQLException;

    public boolean update(Usuario u) throws SQLException;

    public List<Usuario> listAll() throws SQLException;
    
    public Usuario readByEmail(String email) throws SQLException;

}
