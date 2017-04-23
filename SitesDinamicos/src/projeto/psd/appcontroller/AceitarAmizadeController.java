
package projeto.psd.appcontroller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projeto.psd.gerenciadores.GerenciadorAmizade;
import projeto.psd.gerenciadores.GerenciadorPedido;
import projeto.psd.interfaces.Command;

public class AceitarAmizadeController implements Command{

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, ServletException {
        String deEmail = req.getParameter("deEmail");
        String paraEmail = req.getParameter("paraEmail");
        GerenciadorAmizade ger = new GerenciadorAmizade();
        GerenciadorPedido ger2 = new GerenciadorPedido();
        if(ger.add(deEmail, paraEmail)){
            if(ger2.remove(paraEmail, deEmail)){
                res.sendRedirect("Convites.jsp");
            } else {
                // Tratar erro
            }
        } else {
            // Tratar erro
        }
    }
    
}
