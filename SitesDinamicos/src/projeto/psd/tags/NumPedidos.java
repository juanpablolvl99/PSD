
package projeto.psd.tags;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import projeto.psd.entidades.Pedido;
import projeto.psd.gerenciadores.GerenciadorPedido;

public class NumPedidos extends SimpleTagSupport{

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public void doTag(){
        try {
            GerenciadorPedido ger = new GerenciadorPedido();
            List<Pedido> lista = ger.listAll(getEmail());

            getJspContext().setAttribute("numConv", lista.size());
            
            ger.closeConexao();
        } catch (SQLException | ClassNotFoundException ex) {
            //
        }
        //
        
        
    }
    
}
