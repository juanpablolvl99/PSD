package projeto.psd.interfaces;

import java.sql.SQLException;
import java.util.List;
import projeto.psd.entidades.Mensagem;

public interface MensagemDaoIf {

    public boolean add(Mensagem msg) throws SQLException;

    public List<Mensagem> listar(String paraEmail) throws SQLException;
    
    public boolean remove(int id) throws SQLException;

    public void closeConexao() throws SQLException;
}
