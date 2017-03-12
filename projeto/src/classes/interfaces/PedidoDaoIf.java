
package projeto.psd.interfaces;

import java.sql.SQLException;
import java.util.List;
import projeto.psd.entidades.Pedido;

public interface PedidoDaoIf {
    
    public boolean add(String userEmail, String userParaEmail) throws SQLException;
    public boolean remove(String userEmail, String userParaEmail) throws SQLException;   
    public List<Pedido> listAll() throws SQLException;
    
}
