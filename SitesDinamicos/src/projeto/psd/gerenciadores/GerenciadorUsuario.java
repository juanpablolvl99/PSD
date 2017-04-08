
package projeto.psd.gerenciadores;

import java.sql.SQLException;
import java.util.List;
import projeto.psd.entidades.Usuario;
import projeto.psd.factorys.DaoFactory;
import projeto.psd.interfaces.DaoFactoryIf;
import projeto.psd.interfaces.UsuarioDaoIf;

public class GerenciadorUsuario{

    public GerenciadorUsuario(){};
    
    public boolean add(Usuario usu) throws ClassNotFoundException, SQLException{
        
        DaoFactory fabricaDao = new DaoFactory();
        DaoFactoryIf fabricaBd = fabricaDao.getDaoFactory();
        UsuarioDaoIf cad = fabricaBd.criaDaoUsuario();
        return cad.add(usu);
        
    }
    
    public boolean update(Usuario usu) throws ClassNotFoundException, SQLException{
        
        DaoFactory fabricaDao = new DaoFactory();
        DaoFactoryIf fabricaBd = fabricaDao.getDaoFactory();
        UsuarioDaoIf cad = fabricaBd.criaDaoUsuario();
        return cad.update(usu);
        
    }
    
    public List<Usuario> read(String nome) throws ClassNotFoundException, SQLException{
        
        DaoFactory fabricaDao = new DaoFactory();
        DaoFactoryIf fabricabd = fabricaDao.getDaoFactory();
        UsuarioDaoIf cad = fabricabd.criaDaoUsuario();
        return cad.read(nome);
        
    }
    
    public boolean remove(String login, String senha) throws ClassNotFoundException, SQLException{
       
        DaoFactory fabricaDao = new DaoFactory();
        DaoFactoryIf fabricaBd = fabricaDao.getDaoFactory();
        UsuarioDaoIf cad = fabricaBd.criaDaoUsuario();
        return cad.remove(login, senha);
        
    }
    
    public List<Usuario> listAll() throws ClassNotFoundException, SQLException{
        
        DaoFactory fabricaDao = new DaoFactory();
        DaoFactoryIf fabricaBd = fabricaDao.getDaoFactory();
        UsuarioDaoIf cad = fabricaBd.criaDaoUsuario();
        return cad.listAll();
        
    }
    
}
