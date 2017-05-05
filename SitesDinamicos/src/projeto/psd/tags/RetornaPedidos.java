
package projeto.psd.tags;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import projeto.psd.entidades.Pedido;
import projeto.psd.entidades.Relacionamento;
import projeto.psd.gerenciadores.GerenciadorPedido;
import projeto.psd.gerenciadores.GerenciadorRelacionamento;

public class RetornaPedidos extends SimpleTagSupport {
    
    private String userEmail;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }    
    
    @Override
    public void doTag(){
        try {
            boolean cond = false;
            GerenciadorPedido ger = new GerenciadorPedido();
            GerenciadorRelacionamento ger2 = new GerenciadorRelacionamento();
            List<Pedido> lista = ger.listAllRelacionamento(userEmail);
            List<Pedido> lista2 = ger.listRelacionamento(userEmail);
            Relacionamento rel = ger2.retornaRelac(userEmail);
            if(rel.getStatus() == null){
                cond = true;
            }
            getJspContext().setAttribute("numPedidos", lista.size());
            getJspContext().setAttribute("numPedidosFeitos", lista2.size());
            getJspContext().setAttribute("relac", lista);
            getJspContext().setAttribute("rlcExist", cond);
            getJspContext().setAttribute("relacionamento", rel);
            ger.closeConexao();
        } catch (SQLException ex) {
            
        } catch (ClassNotFoundException ex) {
           
        }
    }
    
}
