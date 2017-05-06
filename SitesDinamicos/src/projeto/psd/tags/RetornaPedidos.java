
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
    private String userParaEmail;

    public String getUserParaEmail() {
        return userParaEmail;
    }

    public void setUserParaEmail(String userParaEmail) {
        this.userParaEmail = userParaEmail;
    }
    
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }    
    
    @Override
    public void doTag(){
        try {
            boolean meuRelacionamentoExiste = false;
            boolean relacionamentoOutroExiste = false;
            GerenciadorPedido ger = new GerenciadorPedido();
            GerenciadorRelacionamento ger2 = new GerenciadorRelacionamento();
            List<Pedido> lista = ger.listAllRelacionamento(userEmail);
            List<Pedido> lista2 = ger.listRelacionamento(userEmail);
            Relacionamento rel = ger2.retornaRelac(userEmail);
            Relacionamento rel2 = ger2.retornaRelac(userParaEmail);
            boolean pedidoExiste = ger.vrfPedidoFeito(userParaEmail, userEmail);
            boolean excluirRelac = ger2.verificaRelacionamento(userEmail, userParaEmail);
            if(rel2.getStatus() == null){
                relacionamentoOutroExiste = true;
            }
            if(rel.getStatus() == null){
                meuRelacionamentoExiste = true;
            }
            getJspContext().setAttribute("numPedidos", lista.size());
            getJspContext().setAttribute("numPedidosFeitos", lista2.size());
            getJspContext().setAttribute("relac", lista);
            getJspContext().setAttribute("rlcExist", meuRelacionamentoExiste);
            getJspContext().setAttribute("rlcOutroExist", relacionamentoOutroExiste);
            getJspContext().setAttribute("pddExist", pedidoExiste);
            getJspContext().setAttribute("excRlc", excluirRelac);
            getJspContext().setAttribute("relacionamento", rel);
            ger.closeConexao();
        } catch (SQLException ex) {
            
        } catch (ClassNotFoundException ex) {
           
        }
    }
    
}
