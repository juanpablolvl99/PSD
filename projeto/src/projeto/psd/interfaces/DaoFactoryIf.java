package projeto.psd.interfaces;

import java.sql.SQLException;

public interface DaoFactoryIf {
    public UsuarioDaoIf criaDaoUsuario();
    public MensagemDaoIf criaDaoMensagem() throws SQLException, ClassNotFoundException;
    //...
}
