package projeto.psd.tags;

import java.sql.SQLException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import projeto.psd.gerenciadores.GerenciadorMensagem;

public class NumMensagens extends SimpleTagSupport{
    
    @Override
    public void doTag(){
        
        String email = (String) getJspContext().getAttribute("emailUsuario", PageContext.SESSION_SCOPE);
       
        try {
            GerenciadorMensagem gm = new GerenciadorMensagem();
            getJspContext().setAttribute("contMensagens", gm.listAll(email).size());
        } catch (SQLException | ClassNotFoundException ex) {
        //    
        }
        
    }
    
}
