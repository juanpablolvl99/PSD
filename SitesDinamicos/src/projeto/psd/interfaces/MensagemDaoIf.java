package projeto.psd.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface MensagemDaoIf {

    public boolean add(String userDeEmail, String userParaEmail, String mensagem) throws SQLException;

    public List<String> listar(String deEmail, String paraEmail) throws SQLException;

}
