
package projeto.psd.interfaces;

import java.sql.SQLException;
import projeto.psd.entidades.Relacionamento;

public interface RelacionamentoDaoIf {
    
    public boolean add(Relacionamento r) throws SQLException;
    
    public boolean remove(String emailUser, String emailPara) throws SQLException;
    
    public boolean remove2(String emailUser) throws SQLException;
    
    public Relacionamento retornaRelac(String email) throws SQLException;
    
    public boolean verificaRelacionamento(String email, String paraEmail) throws SQLException;
    
    public void closeConexao() throws SQLException;
    
}
