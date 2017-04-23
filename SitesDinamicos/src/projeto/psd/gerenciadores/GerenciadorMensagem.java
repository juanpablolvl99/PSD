package projeto.psd.gerenciadores;

import java.sql.SQLException;
import java.util.List;
import projeto.psd.entidades.Mensagem;
import projeto.psd.factorys.DaoFactory;
import projeto.psd.interfaces.MensagemDaoIf;

public class GerenciadorMensagem {

    private DaoFactory fabricaDao;
    private MensagemDaoIf ifc;

    public GerenciadorMensagem() throws SQLException, ClassNotFoundException {
        this.fabricaDao = new DaoFactory();
        this.ifc = fabricaDao.getDaoFactory().criaDaoMensagem();
    }
    
    public boolean add(Mensagem msg) throws SQLException, ClassNotFoundException {

        return this.ifc.add(msg);

    }

    public List<Mensagem> listAll(String deEmail, String paraEmail) throws SQLException, ClassNotFoundException {

        return this.ifc.listar(deEmail, paraEmail);

    }

}
