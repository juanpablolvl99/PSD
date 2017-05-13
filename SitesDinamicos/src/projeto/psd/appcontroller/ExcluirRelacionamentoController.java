package projeto.psd.appcontroller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projeto.psd.gerenciadores.GerenciadorRelacionamento;
import projeto.psd.interfaces.Command;

public class ExcluirRelacionamentoController implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, ServletException {

        GerenciadorRelacionamento gr = new GerenciadorRelacionamento();

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
