
package projeto.psd.appcontroller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projeto.psd.gerenciadores.GerenciadorPedido;
import projeto.psd.interfaces.Command;

public class ExcluirPedidoController implements Command{

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, ServletException {
        String deEmail = req.getParameter("deEmail");
        String paraEmail = req.getParameter("paraEmail");
        GerenciadorPedido ger = new GerenciadorPedido();
        if(ger.remove(deEmail, paraEmail)){
            res.sendRedirect("Inicial.jsp");
        } else {
            // Tratar o erro
        }
    }
    
}
