
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
            boolean condicaoPedido = true;
            boolean condicaoAmizade = true;
            GerenciadorPedido ger = new GerenciadorPedido();
            List<Pedido> pedidos = ger.vrfPedido(deEmail, paraEmail);
            GerenciadorAmizade ger2 = new GerenciadorAmizade();
            List<Amizade> amizades = ger2.vrfAmizade(deEmail, paraEmail);
            if(!amizades.isEmpty()){
                condicaoAmizade = false;
            }
            if(!pedidos.isEmpty()){
                condicaoPedido = false;
            }
            
//            for(Pedido p: lista){
//                if(deEmail.equals(p.getUserEmail()) && paraEmail.equals(p.getUserParaEmail())){
//                    condPedidoEnviado = false;
//                }
//                if(paraEmail.equals(p.getUserEmail()) && deEmail.equals(p.getUserParaEmail())){
//                    condPedidoRecebido = false;
//                }
//            }
//            for(Amizade a: lista2){
//                if(deEmail.equals(a.getUserEmail()) && paraEmail.equals(a.getAmigoEmail())){
//                    amizade = false;
//                }
//                if(paraEmail.equals(a.getUserEmail()) && deEmail.equals(a.getAmigoEmail())){
//                    amizade2 = false;
//                }
//            }
            
            ger.closeConexao();
            ger2.closeConexao();
            
            getJspContext().setAttribute("condicaoPedido", condicaoPedido);
            getJspContext().setAttribute("condicaoAmizade", condicaoAmizade);
            
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
}
