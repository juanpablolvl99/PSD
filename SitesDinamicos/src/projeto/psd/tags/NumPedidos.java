
package projeto.psd.tags;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import projeto.psd.entidades.Pedido;
import projeto.psd.gerenciadores.GerenciadorPedido;

public class NumPedidos extends SimpleTagSupport{

    private String deEmail;

    public String getDeEmail() {
        return deEmail;
    }

    public void setDeEmail(String deEmail) {
        this.deEmail = deEmail;
    }
    
    @Override
    public void doTag(){
        try {
            GerenciadorPedido ger = new GerenciadorPedido();
            List<Pedido> lista = ger.listAll();
            int cont = 0;
            for(Pedido p: lista){
                if(deEmail.equals(p.getUserEmail()) || deEmail.equals(p.getUserParaEmail())){
                    cont++;
                }
            }
            getJspContext().setAttribute("numConv", cont);
        } catch (SQLException ex) {
            //
        } catch (ClassNotFoundException ex) {
            //
        }
        
    }
    
}
