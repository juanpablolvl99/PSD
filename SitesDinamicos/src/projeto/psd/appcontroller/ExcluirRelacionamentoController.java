package projeto.psd.appcontroller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import projeto.psd.entidades.Usuario;
import projeto.psd.gerenciadores.GerenciadorRelacionamento;
import projeto.psd.gerenciadores.GerenciadorUsuario;
import projeto.psd.interfaces.Command;

public class ExcluirRelacionamentoController implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, ServletException {

        GerenciadorRelacionamento gr = new GerenciadorRelacionamento();

        String userEmail = retornaComEncode(req.getParameter("user"));
        String userPara = retornaComEncode(req.getParameter("other"));

        GerenciadorUsuario gr2 = new GerenciadorUsuario();
        gr2.updateStatus(userEmail, "Solteiro");
        gr2.updateStatus(userPara, "Solteiro");
        HttpSession session = req.getSession(false);
        
        synchronized(session){
            Usuario user = (Usuario) session.getAttribute("dadosUsu");
            user.setStatus("Solteiro");
            session.setAttribute("dadosUsu", user);
        }
        
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
