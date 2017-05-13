package projeto.psd.appcontroller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

        GerenciadorRelacionamento gr = new GerenciadorRelacionamento();
        String email = req.getParameter("email");
        String paraEmail = req.getParameter("paraEmail");
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
        String userEmail = retornaComEncode(req.getParameter("user"));
        String userPara = retornaComEncode(req.getParameter("other"));

        if (gr.remove(userEmail, userPara)) {
            gr.closeConexao();
            res.sendRedirect("InformUsu.jsp?current=" + userPara);
        } else {
            gr.closeConexao();
            res.sendError(333);
        }

    }

    private String retornaComEncode(String value) throws UnsupportedEncodingException {
        return new String(value.getBytes(), "UTF-8");
    }
}
