package projeto.psd.tags;

import java.sql.SQLException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import projeto.psd.gerenciadores.GerenciadorGaleria;

public class CarregaFotos extends SimpleTagSupport{
    
    @Override
    public void doTag(){
        
        GerenciadorGaleria ger;
        try {
            ger = new GerenciadorGaleria();
            getJspContext().setAttribute("list", ger.listAll((String)getJspContext().getAttribute("emailUsuario", 3)));
        } catch (SQLException | ClassNotFoundException ex) {
            
        }
        
    }
    
}
