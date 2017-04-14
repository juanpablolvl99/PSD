package projeto.psd.gerenciadores;

import java.sql.SQLException;
import java.util.List;
import projeto.psd.factorys.DaoFactory;
import projeto.psd.interfaces.MensagemDaoIf;

public class GerenciadorMensagem {

    private DaoFactory fabricaDao;
    private MensagemDaoIf ifc;

    public GerenciadorMensagem() throws SQLException, ClassNotFoundException {
        this.fabricaDao = new DaoFactory();
        this.ifc = fabricaDao.getDaoFactory().criaDaoMensagem();
    }
    
    public boolean add(String deEmail, String paraEmail, String mensagem) throws SQLException, ClassNotFoundException {

        return this.ifc.add(deEmail, paraEmail, mensagem);

    }

    public List<String> listAll(String deEmail, String paraEmail) throws SQLException, ClassNotFoundException {

        return this.ifc.listar(deEmail, paraEmail);

    }

}
