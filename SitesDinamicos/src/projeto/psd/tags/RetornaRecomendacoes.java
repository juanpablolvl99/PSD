package projeto.psd.tags;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import projeto.psd.entidades.Recomendacao;
import projeto.psd.gerenciadores.GerenciadorRecom;

public class RetornaRecomendacoes extends SimpleTagSupport{
    
    private String email;
    
    public void setEmail(String email){
        this.email = email;
    };
    
    public String getEmail(){
        return this.email;
    }
    
    @Override
    public void doTag(){
        
        try {
            GerenciadorRecom gr = new GerenciadorRecom();
            List<Recomendacao> lista = gr.listAll(this.email);
            
            getJspContext().setAttribute("recomendacoes", lista);
            
            gr.closeConexao();
        } catch (SQLException | ClassNotFoundException ex) {
            //
        }
        
    }
    
}
