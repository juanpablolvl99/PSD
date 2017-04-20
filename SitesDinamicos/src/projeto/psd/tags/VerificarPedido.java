
package projeto.psd.tags;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import projeto.psd.entidades.Pedido;
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
            boolean condicao = true;
            GerenciadorPedido ger = new GerenciadorPedido();
            List<Pedido> lista = ger.listAll();
            for(Pedido p: lista){
                if(deEmail.equals(p.getUserEmail()) && paraEmail.equals(p.getUserParaEmail())){
                    condicao = false;
                }
            }
            getJspContext().setAttribute("cond", condicao);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
}
