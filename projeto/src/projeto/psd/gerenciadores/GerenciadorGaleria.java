package projeto.psd.gerenciadores;

import java.sql.SQLException;
import java.util.List;
import projeto.psd.factorys.DaoFactory;
import projeto.psd.interfaces.GaleriaDaoIf;

public class GerenciadorGaleria {

    private DaoFactory fabricaDao;
    private GaleriaDaoIf cad;
    
    public GerenciadorGaleria() throws SQLException, ClassNotFoundException {
        this.fabricaDao = new DaoFactory();
        this.cad = this.fabricaDao.getDaoFactory().criaDaoGaleria();
    };
    
    public boolean add(String user, String imagem) throws SQLException{
        return cad.add(user, imagem);
    }

    public boolean remove(String user, String imagem) throws SQLException{
        return cad.delete(user, imagem);
    }

    public List<String> listAll(String user) throws SQLException{
        return cad.listar(user);
    }

}
