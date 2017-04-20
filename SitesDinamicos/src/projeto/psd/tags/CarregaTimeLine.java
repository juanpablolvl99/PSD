package projeto.psd.tags;

import java.sql.SQLException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import projeto.psd.gerenciadores.GerenciadorGaleria;

public class CarregaTimeLine extends SimpleTagSupport {

    private String email;

    @Override
    public void doTag() {

        GerenciadorGaleria gg;

        try {
            gg = new GerenciadorGaleria();
            getJspContext().setAttribute("datas", gg.getDatas(email));
        } catch (SQLException | ClassNotFoundException ex) {

        }

    }

    public void setEmail(String email) {
        this.email = email;
    }

}
