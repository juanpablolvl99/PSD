
package projeto.psd.tags;

import java.sql.SQLException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import projeto.psd.entidades.Usuario;
import projeto.psd.gerenciadores.GerenciadorUsuario;

public class RetornarUsuarioEmail extends SimpleTagSupport{
    
    private String email;
    
    public String getEmail(){
        return this.email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    @Override
    public void doTag(){
        try {
            GerenciadorUsuario ger = new GerenciadorUsuario();
            Usuario auxiliar = ger.readByEmail(email);
            getJspContext().setAttribute("emailConvite", auxiliar);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
}
