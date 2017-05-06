
package projeto.psd.tags;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import projeto.psd.entidades.Amizade;
import projeto.psd.entidades.Pedido;
import projeto.psd.gerenciadores.GerenciadorAmizade;
import projeto.psd.gerenciadores.GerenciadorPedido;

public class VerificarPedido extends SimpleTagSupport{
    
    private String deEmail;
    private String paraEmail;
    
    public String getDeEmail() {
        return deEmail;
    }

    public void setDeEmail(String deEmail) {
        this.deEmail = deEmail;
    }

    public String getParaEmail() {
        return paraEmail;
    }

    public void setParaEmail(String paraEmail) {
        this.paraEmail = paraEmail;
    } 
    
    @Override
    public void doTag(){
        try {
//            boolean condPedidoEnviado = true;
//            boolean condPedidoRecebido = true;
//            boolean amizade = true;
//            boolean amizade2 = true;
            boolean condicaoPedido = false;
            boolean condicaoAmizade = false;
            GerenciadorPedido ger = new GerenciadorPedido();
            List<Pedido> pedidos = ger.vrfPedido(deEmail, paraEmail);
            GerenciadorAmizade ger2 = new GerenciadorAmizade();
            List<Amizade> amizades = ger2.vrfAmizade(deEmail, paraEmail);
            if(!amizades.isEmpty()){
                condicaoAmizade = true;
            }
            if(!pedidos.isEmpty()){
                condicaoPedido = true;
            }
            
            
            ger.closeConexao();
            ger2.closeConexao();
            
            getJspContext().setAttribute("condicaoPedido", condicaoPedido);
            getJspContext().setAttribute("condicaoAmizade", condicaoAmizade);
            
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
}
