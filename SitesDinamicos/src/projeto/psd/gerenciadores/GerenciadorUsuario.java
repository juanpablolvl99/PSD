package projeto.psd.gerenciadores;

import java.sql.SQLException;
import java.util.List;
import projeto.psd.entidades.Usuario;
import projeto.psd.factorys.DaoFactory;
import projeto.psd.interfaces.UsuarioDaoIf;

public class GerenciadorUsuario {

    private DaoFactory fabricaDao;
    private UsuarioDaoIf ifc;

    public GerenciadorUsuario() throws ClassNotFoundException, SQLException {
        this.fabricaDao = new DaoFactory();
        this.ifc = fabricaDao.getDaoFactory().criaDaoUsuario();
    }
    
    public boolean add(Usuario usu) throws ClassNotFoundException, SQLException {

        return this.ifc.add(usu);

    }

    public boolean update(Usuario usu) throws ClassNotFoundException, SQLException {

        return this.ifc.update(usu);

    }

    public List<Usuario> read(String nome) throws ClassNotFoundException, SQLException {

        return this.ifc.read(nome);

    }

    public boolean remove(String login, String senha) throws ClassNotFoundException, SQLException {

        return this.ifc.remove(login, senha);

    }

    public List<Usuario> listAll() throws ClassNotFoundException, SQLException {

        return this.ifc.listAll();

    }
    
    public Usuario readEmail(String email) throws SQLException{
        
        return this.ifc.readEmail(email);
        
    }

}
