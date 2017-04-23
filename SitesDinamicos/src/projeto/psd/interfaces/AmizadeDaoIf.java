package projeto.psd.interfaces;

import java.sql.SQLException;
import java.util.List;
import projeto.psd.entidades.Amizade;

public interface AmizadeDaoIf {

    public boolean add(String userEmail, String amigoEmail) throws SQLException;

    public boolean remove(String userEmail, String amigoEmail) throws SQLException;

    public List<Amizade> listAll(String email) throws SQLException;

    public List<Amizade> listAll() throws SQLException;

    public void closeConexao() throws SQLException;
}
