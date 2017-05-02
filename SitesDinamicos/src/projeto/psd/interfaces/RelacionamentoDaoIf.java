
package projeto.psd.interfaces;

import java.sql.SQLException;
import projeto.psd.entidades.Relacionamento;

public interface RelacionamentoDaoIf {
    
    public boolean add(Relacionamento r) throws SQLException;
    
    public boolean remove(Relacionamento r) throws SQLException;
    
    public Relacionamento listAll(String email) throws SQLException;
    
    public void closeConexao() throws SQLException;
    
}
