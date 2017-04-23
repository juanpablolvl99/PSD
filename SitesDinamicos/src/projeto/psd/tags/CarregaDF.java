package projeto.psd.tags;

import java.sql.SQLException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import projeto.psd.gerenciadores.GerenciadorGaleria;

public class CarregaDF extends SimpleTagSupport {

    private String email;
    private String retorna;

    @Override
    public void doTag() {

        GerenciadorGaleria gg;

        try {
            gg = new GerenciadorGaleria();
            
            if(retorna.equals("fotos"))
                getJspContext().setAttribute("fotos", gg.listAll(email));
            
            if(retorna.equals("datas"))
                getJspContext().setAttribute("datas", gg.getDatas(email));
            
            gg.closeConexao();
        } catch (SQLException | ClassNotFoundException ex) {

        }

    }

    public void setRetorna(String tipo) {
        this.retorna = tipo;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

}
