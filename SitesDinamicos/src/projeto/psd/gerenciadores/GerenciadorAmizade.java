package projeto.psd.gerenciadores;

import java.sql.SQLException;
import java.util.List;
import projeto.psd.entidades.Amizade;
import projeto.psd.factorys.DaoFactory;
import projeto.psd.interfaces.AmizadeDaoIf;

public class GerenciadorAmizade {

    private DaoFactory fabricaDao;
    private AmizadeDaoIf ifc;

    public GerenciadorAmizade() throws SQLException, ClassNotFoundException {
        this.fabricaDao = new DaoFactory();
        this.ifc = this.fabricaDao.getDaoFactory().criaDaoAmizade();
    }

    public boolean add(String userEmail, String amigoEmail) throws SQLException {
    
        return this.ifc.add(userEmail, amigoEmail);
    }
    

    public boolean remove(String userEmail, String amigoEmail) throws SQLException {
    
        return this.ifc.remove(userEmail, amigoEmail);
    }
    

    public List<Amizade> listAll() throws SQLException {
    
        return this.ifc.listAll();
    }
    
}
