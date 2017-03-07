package projeto.psd.factorys;

import java.sql.SQLException;
import projeto.psd.daos.MensagemDao;
import projeto.psd.daos.UsuarioDao;
import projeto.psd.interfaces.DaoFactoryIf;
import projeto.psd.interfaces.MensagemDaoIf;
import projeto.psd.interfaces.UsuarioDaoIf;

public class DaoFactoryDB implements DaoFactoryIf{

    private static DaoFactoryDB instance;
    
    private DaoFactoryDB(){};
    
    @Override
    public UsuarioDaoIf criaDaoUsuario() {
        return new UsuarioDao();
    }

    @Override
    public MensagemDaoIf criaDaoMensagem() throws SQLException, ClassNotFoundException{
        return new MensagemDao();
    }
    
    //...
    
    public static synchronized DaoFactoryDB getInstance(){
        if(instance == null){
            return instance = new DaoFactoryDB();
        }
        return instance;
    }
    
}
