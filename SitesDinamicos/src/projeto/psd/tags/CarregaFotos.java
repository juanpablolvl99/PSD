package projeto.psd.tags;

import java.sql.SQLException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import projeto.psd.gerenciadores.GerenciadorGaleria;

public class CarregaFotos extends SimpleTagSupport {

    private String email;
    
    @Override
    public void doTag() {

        GerenciadorGaleria gg;
        
        try {
            gg = new GerenciadorGaleria();
            getJspContext().setAttribute("list", gg.listAll(email));
        } catch (SQLException | ClassNotFoundException ex) {

        }

    }
    
    public void setEmail(String email){
        this.email = email;
    }

}