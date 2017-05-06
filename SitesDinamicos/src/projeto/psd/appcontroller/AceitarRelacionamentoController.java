
package projeto.psd.appcontroller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projeto.psd.entidades.Relacionamento;
import projeto.psd.gerenciadores.GerenciadorPedido;
import projeto.psd.gerenciadores.GerenciadorRelacionamento;
import projeto.psd.gerenciadores.GerenciadorUsuario;
import projeto.psd.interfaces.Command;

public class AceitarRelacionamentoController implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, ServletException {
        String email = req.getParameter("email");
        String paraEmail = req.getParameter("paraEmail");
        String status = req.getParameter("status");
        Relacionamento r = new Relacionamento();
        r.setUserEmail(email);
        r.setUserParaEmail(paraEmail);
        r.setStatus(status);
        GerenciadorRelacionamento ger = new GerenciadorRelacionamento();
        GerenciadorPedido ger2 = new GerenciadorPedido();
        GerenciadorUsuario ger3 = new GerenciadorUsuario();
        ger3.updateStatus(email, status);
        ger3.updateStatus(paraEmail, status);
        if(ger.add(r)){
            ger2.removeRelacionamento(email, paraEmail);
            res.sendRedirect("Inicial.jsp");
            ger.closeConexao();
        } else {
            res.sendError(333);
            ger.closeConexao();
        }
    }
    
}
