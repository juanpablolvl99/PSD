package projeto.psd.interfaces;

import java.sql.SQLException;
import java.util.List;
import projeto.psd.entidades.Recomendacao;

public interface RecomendacaoDaoIf {
    
    public boolean add(Recomendacao rec) throws ClassNotFoundException, SQLException;
    
    public boolean remove(String recomendadoEmail, String paraEmail) throws ClassNotFoundException, SQLException;
    
    public List listAll(String email) throws ClassNotFoundException, SQLException;
    
    public void closeConexao() throws SQLException;
    
}
