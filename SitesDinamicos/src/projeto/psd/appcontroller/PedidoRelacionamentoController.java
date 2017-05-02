
package projeto.psd.appcontroller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projeto.psd.gerenciadores.GerenciadorPedido;
import projeto.psd.interfaces.Command;

public class PedidoRelacionamentoController implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, ServletException {
        String userEmail = req.getParameter("userEmail");
        String userParaEmail = req.getParameter("userParaEmail");
        String status = req.getParameter("status");
        GerenciadorPedido ger = new GerenciadorPedido();
        if(ger.addRelacionamento(userEmail, userParaEmail, status)){
            ger.closeConexao();
            res.sendRedirect("InformUsu.jsp?current="+userParaEmail);
        } else {
            ger.closeConexao();
            res.sendError(333);
        }
        
    }
    
    
    
}
