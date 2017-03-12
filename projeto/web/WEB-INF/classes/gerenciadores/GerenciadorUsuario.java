
package projeto.psd.gerenciadores;

import java.sql.SQLException;
import java.util.List;
import projeto.psd.entidades.Usuario;
import projeto.psd.factorys.DaoFactory;
import projeto.psd.interfaces.UsuarioDaoIf;

public class GerenciadorUsuario{
    
    private DaoFactory fabricaDao;
    private UsuarioDaoIf cad;
    
    public GerenciadorUsuario() throws ClassNotFoundException, SQLException{
        fabricaDao = new DaoFactory();
        this.cad = this.fabricaDao.getDaoFactory().criaDaoUsuario();
    };
    
    public boolean add(String login, String senha, String nome, String apelido, String dataDeNascimento, String cidade, String email,
    String profissao, String descricao, String status, double altura, double peso, String corDoCabelo, String passatempos, 
    String fotoPerfil) throws SQLException{
        Usuario user = new Usuario(login, senha, nome, apelido, dataDeNascimento, cidade, email, profissao, descricao, status, altura,
        peso, corDoCabelo, passatempos, fotoPerfil);
        return cad.add(user);
        
    }
    
    public boolean update(String login, String senha, String nome, String apelido, String dataDeNascimento, String cidade, 
    String email, String profissao, String descricao, String status, double altura, double peso, String corDoCabelo, String passatempos, 
    String fotoPerfil) throws SQLException{
        
        Usuario user = new Usuario(login, senha, nome, apelido, dataDeNascimento, cidade, email, profissao, descricao, status, altura,
        peso, corDoCabelo, passatempos, fotoPerfil);
        return cad.update(user);
        
    }
    
    public boolean remove(String login, String senha) throws SQLException{
        return cad.remove(login, senha);
    }
    
    public List<Usuario> listAll() throws ClassNotFoundException, SQLException{
        return cad.listAll();
    }
    
}
