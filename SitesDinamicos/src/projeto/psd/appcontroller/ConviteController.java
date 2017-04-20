
package projeto.psd.appcontroller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projeto.psd.gerenciadores.GerenciadorPedido;
import projeto.psd.interfaces.Command;

public class ConviteController implements Command{

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, ServletException {
       
        String deUsu = req.getParameter("deUsuario");
        String paraUsu = req.getParameter("paraUsuario");
        GerenciadorPedido ger = new GerenciadorPedido();
        
        if(ger.add(deUsu, paraUsu)){
            res.sendRedirect("Convites.jsp");
        } else {
            // Tratar erro
        }
        
    }
    
}
