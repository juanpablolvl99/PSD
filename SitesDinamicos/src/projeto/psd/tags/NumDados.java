package projeto.psd.tags;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import projeto.psd.entidades.Mensagem;
import projeto.psd.entidades.Pedido;
import projeto.psd.entidades.Recomendacao;
import projeto.psd.gerenciadores.GerenciadorMensagem;
import projeto.psd.gerenciadores.GerenciadorPedido;
import projeto.psd.gerenciadores.GerenciadorRecom;

public class NumDados extends SimpleTagSupport {

    private String retorno;

    public String getRetorno() {
        return retorno;
    }

    public void setRetorno(String value) {
        this.retorno = value;
    }

    @Override
    public void doTag() {
        String email = (String) getJspContext().getAttribute("emailUsuario", PageContext.SESSION_SCOPE);

        try {
            GerenciadorPedido ger = new GerenciadorPedido();
            GerenciadorMensagem gm = new GerenciadorMensagem();
            GerenciadorRecom gr = new GerenciadorRecom();
            
            switch (getRetorno()) {
                case "pedidos":
                    List<Pedido> listaP = ger.listAll(email);
                    getJspContext().setAttribute("numConv", listaP.size());
                    break;
                    
                case "mensagens":
                    List<Mensagem> listaM = gm.listAll(email);
                    getJspContext().setAttribute("contMensagens", listaM.size());
                    break;
                    
                case "recomendacoes":
                    List<Recomendacao> listaR = gr.listAll(email);
                    getJspContext().setAttribute("contRecom", listaR.size());
                    break;
            }
            
            gr.closeConexao();
            gm.closeConexao();
            ger.closeConexao();
        } catch (SQLException | ClassNotFoundException ex) {
            //
        }
        //

    }

}
