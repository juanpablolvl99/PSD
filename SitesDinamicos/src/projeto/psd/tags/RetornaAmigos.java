package projeto.psd.tags;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import projeto.psd.entidades.Amizade;
import projeto.psd.entidades.Usuario;
import projeto.psd.gerenciadores.GerenciadorAmizade;
import projeto.psd.gerenciadores.GerenciadorUsuario;

public class RetornaAmigos extends SimpleTagSupport{
    
    private String email;
    
    @Override
    public void doTag(){
        
        try {
            GerenciadorAmizade ga = new GerenciadorAmizade(); // (G)uardian (A)ngel
            GerenciadorUsuario gu = new GerenciadorUsuario();
            List<Amizade> amizades = ga.listAll(email);
            List<Usuario> amigos = new ArrayList<>();
            
            for (Amizade amizade : amizades) {
                if(amizade.getUserEmail().equals(getEmail()))
                    amigos.add(gu.readByEmail(amizade.getAmigoEmail()));
                else
                    amigos.add(gu.readByEmail(amizade.getUserEmail()));
            }
            
            
            getJspContext().setAttribute("amigos", amigos);
            
            ga.closeConexao();
        } catch (SQLException | ClassNotFoundException ex) {
            //
        }
        
    }
    
    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    
}
