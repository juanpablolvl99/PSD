package projeto.psd.appcontroller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projeto.psd.gerenciadores.GerenciadorRelacionamento;
import projeto.psd.gerenciadores.GerenciadorUsuario;
import projeto.psd.interfaces.Command;

public class ExcluirRelacionamentoController implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, ServletException {

        String email = req.getParameter("email");
        String paraEmail = req.getParameter("paraEmail");
        GerenciadorRelacionamento gr = new GerenciadorRelacionamento();
        GerenciadorUsuario gr2 = new GerenciadorUsuario();
        gr2.updateStatus(email, "Solteiro");
        gr2.updateStatus(paraEmail, "Solteiro");
        if (gr.remove(email, paraEmail)) {
            res.sendRedirect("InformUsu.jsp?current=" + paraEmail);
            gr.closeConexao();
        } else {
            res.sendError(333);
            gr.closeConexao();
        }

    }

}
