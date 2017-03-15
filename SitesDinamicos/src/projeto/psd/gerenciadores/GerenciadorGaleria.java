package projeto.psd.gerenciadores;

import java.sql.SQLException;
import java.util.List;
import projeto.psd.factorys.DaoFactory;
import projeto.psd.interfaces.DaoFactoryIf;
import projeto.psd.interfaces.GaleriaDaoIf;

public class GerenciadorGaleria {

    public GerenciadorGaleria() {};
    
    public boolean add(String user, String imagem) throws SQLException, ClassNotFoundException {

        DaoFactory fabricaDao = new DaoFactory();
        DaoFactoryIf fabricaDaoBd = fabricaDao.getDaoFactory();
        GaleriaDaoIf cad = fabricaDaoBd.criaDaoGaleria();
        return cad.add(user, imagem);

    }

    public boolean remove(String user, String imagem) throws SQLException, ClassNotFoundException {

        DaoFactory fabricaDao = new DaoFactory();
        DaoFactoryIf fabricaDaoBd = fabricaDao.getDaoFactory();
        GaleriaDaoIf cad = fabricaDaoBd.criaDaoGaleria();
        return cad.delete(user, imagem);

    }

    public List<String> listAll(String user) throws SQLException, ClassNotFoundException {

        DaoFactory fabricaDao = new DaoFactory();
        DaoFactoryIf fabricaDaoBd = fabricaDao.getDaoFactory();
        GaleriaDaoIf cad = fabricaDaoBd.criaDaoGaleria();
        return cad.listar(user);

    }

}
