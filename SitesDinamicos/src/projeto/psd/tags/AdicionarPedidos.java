
package projeto.psd.tags;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import projeto.psd.entidades.Pedido;
import projeto.psd.gerenciadores.GerenciadorPedido;

public class AdicionarPedidos extends SimpleTagSupport {
    
    @Override
    public void doTag(){
        GerenciadorPedido ger;
        try {
            ger = new GerenciadorPedido();
            List<Pedido> lista = ger.listAll();
            int num = lista.size();
            getJspContext().setAttribute("convites", lista);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
    }
    
}
