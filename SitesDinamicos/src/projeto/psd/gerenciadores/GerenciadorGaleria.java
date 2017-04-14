package projeto.psd.gerenciadores;

import java.sql.SQLException;
import java.util.List;
import projeto.psd.factorys.DaoFactory;
import projeto.psd.interfaces.GaleriaDaoIf;

public class GerenciadorGaleria {

    private DaoFactory fabricaDao;
    private GaleriaDaoIf ifc;

    public GerenciadorGaleria() throws SQLException, ClassNotFoundException {
        this.fabricaDao = new DaoFactory();
        this.ifc = fabricaDao.getDaoFactory().criaDaoGaleria();
    }

    public boolean add(String user, String imagem) throws SQLException, ClassNotFoundException {

        return this.ifc.add(user, imagem);

    }

    public boolean remove(String user, String imagem) throws SQLException, ClassNotFoundException {

        return this.ifc.delete(user, imagem);

    }

    public List<String> listAll(String user) throws SQLException, ClassNotFoundException {

        return this.ifc.listar(user);

    }

}
