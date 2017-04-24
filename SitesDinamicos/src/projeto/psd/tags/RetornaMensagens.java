package projeto.psd.tags;

import java.sql.SQLException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import projeto.psd.gerenciadores.GerenciadorMensagem;

public class RetornaMensagens extends SimpleTagSupport {
    
    private String email;
    
    @Override
    public void doTag(){
    
        try {
            GerenciadorMensagem gm = new GerenciadorMensagem(); // game master
            getJspContext().setAttribute("mensagens", gm.listAll(email));
        } catch (SQLException | ClassNotFoundException ex) {
        //
        }
        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
