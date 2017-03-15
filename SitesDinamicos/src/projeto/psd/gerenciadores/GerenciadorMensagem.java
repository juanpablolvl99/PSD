package projeto.psd.gerenciadores;

import java.sql.SQLException;
import java.util.List;
import projeto.psd.factorys.DaoFactory;
import projeto.psd.interfaces.DaoFactoryIf;
import projeto.psd.interfaces.MensagemDaoIf;

public class GerenciadorMensagem {
    
    public GerenciadorMensagem(){};
    
    public boolean add (String deEmail, String paraEmail, String mensagem) throws SQLException, ClassNotFoundException{
        
        DaoFactory fabricaDao = new DaoFactory();
        DaoFactoryIf fabricaDaoBd = fabricaDao.getDaoFactory();
        MensagemDaoIf cad = fabricaDaoBd.criaDaoMensagem();
        return cad.add(deEmail, paraEmail, mensagem);
        
    }
    
    public List<String> listAll(String deEmail, String paraEmail) throws SQLException, ClassNotFoundException{
        
        DaoFactory fabricaDao = new DaoFactory();
        DaoFactoryIf fabricaDaoBd = fabricaDao.getDaoFactory();
        MensagemDaoIf cad = fabricaDaoBd.criaDaoMensagem();
        return cad.listar(deEmail, paraEmail);
        
    }
    
}
