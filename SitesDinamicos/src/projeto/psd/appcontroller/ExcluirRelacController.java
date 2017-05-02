
package projeto.psd.appcontroller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projeto.psd.gerenciadores.GerenciadorPedido;
import projeto.psd.interfaces.Command;

public class ExcluirRelacController implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, ServletException {
        String email = req.getParameter("email");
        String paraEmail = req.getParameter("paraEmail");
        GerenciadorPedido ger = new GerenciadorPedido();
        if(ger.removeRelacionamento(email, paraEmail)){
            res.sendRedirect("Inicial.jsp");
            ger.closeConexao();
        } else {
            res.sendError(333);
            ger.closeConexao();
        }
    }
    
}
