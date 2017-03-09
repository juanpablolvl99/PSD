package projeto.psd.gerenciadores;

import java.sql.SQLException;
import java.util.List;
import projeto.psd.factorys.DaoFactory;
import projeto.psd.interfaces.MensagemDaoIf;

public class GerenciadorMensagem {
    
    private DaoFactory fabricaDao;
    private MensagemDaoIf cad;
    
    public GerenciadorMensagem() throws SQLException, ClassNotFoundException{
        this.fabricaDao = new DaoFactory();
        this.cad = fabricaDao.getDaoFactory().criaDaoMensagem();
    };
    
    public boolean add (String deEmail, String paraEmail, String mensagem) throws SQLException{
        return cad.add(deEmail, paraEmail, mensagem);
    }
    
    public List<String> listAll(String deEmail, String paraEmail) throws SQLException{
        return cad.listar(deEmail, paraEmail);
    }
    
}
