package projeto.psd.factorys;

import java.sql.SQLException;
import projeto.psd.daos.AmizadeDao;
import projeto.psd.daos.GaleriaDao;
import projeto.psd.daos.MensagemDao;
import projeto.psd.daos.PedidoDao;
import projeto.psd.daos.UsuarioDao;
import projeto.psd.interfaces.AmizadeDaoIf;
import projeto.psd.interfaces.DaoFactoryIf;
import projeto.psd.interfaces.GaleriaDaoIf;
import projeto.psd.interfaces.MensagemDaoIf;
import projeto.psd.interfaces.PedidoDaoIf;
import projeto.psd.interfaces.UsuarioDaoIf;

public class DaoFactoryDB implements DaoFactoryIf{

    private static DaoFactoryDB instance;
    
    private DaoFactoryDB(){};
    
    @Override
    public UsuarioDaoIf criaDaoUsuario() throws ClassNotFoundException, SQLException {
        return new UsuarioDao();
    }

    @Override
    public MensagemDaoIf criaDaoMensagem() throws SQLException, ClassNotFoundException{
        return new MensagemDao();
    }
    
    @Override
    public PedidoDaoIf criaDaoPedido() throws SQLException, ClassNotFoundException{
        return new PedidoDao();
    }
    
    @Override
    public AmizadeDaoIf criaDaoAmizade() throws SQLException, ClassNotFoundException{
        return new AmizadeDao();
    }
    
    @Override
    public GaleriaDaoIf criaDaoGaleria() throws SQLException, ClassNotFoundException{
        return new GaleriaDao();
    }
    
    public static synchronized DaoFactoryDB getInstance(){
        if(instance == null){
            return instance = new DaoFactoryDB();
        }
        return instance;
    }
    
}
