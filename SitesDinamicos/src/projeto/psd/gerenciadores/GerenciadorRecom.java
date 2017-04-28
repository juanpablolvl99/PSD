package projeto.psd.gerenciadores;

import java.sql.SQLException;
import java.util.List;
import projeto.psd.entidades.Recomendacao;
import projeto.psd.factorys.DaoFactory;
import projeto.psd.interfaces.RecomendacaoDaoIf;

public class GerenciadorRecom {

    private DaoFactory fabricaDao;
    private RecomendacaoDaoIf recIf;

    public GerenciadorRecom() throws SQLException, ClassNotFoundException {
        fabricaDao = new DaoFactory();
        recIf = fabricaDao.getDaoFactory().criarDaoRecomendacao();
    }

    public boolean add(Recomendacao rec) throws ClassNotFoundException, SQLException {
        return this.recIf.add(rec);
    }

    public boolean remove(String recomendadoEmail, String paraEmail) throws ClassNotFoundException, SQLException {
        return this.recIf.remove(recomendadoEmail, paraEmail);
    }
    
    public List listAll(String email) throws ClassNotFoundException, SQLException {
        return this.recIf.listAll(email);
    }

    public void closeConexao() throws SQLException {
        this.recIf.closeConexao();
    }
}
