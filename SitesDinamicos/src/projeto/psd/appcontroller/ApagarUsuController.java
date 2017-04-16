package projeto.psd.appcontroller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projeto.psd.gerenciadores.GerenciadorUsuario;
import projeto.psd.interfaces.Command;

public class ApagarUsuController implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, ServletException {

        String login = req.getParameter("login");
        String senha = req.getParameter("senha");

        GerenciadorUsuario ger;
        ger = new GerenciadorUsuario();

        if (ger.remove(login, senha)) {
            String url = res.encodeRedirectURL("index.htm");
            res.sendRedirect(url);
        } else {
            // Tratar o erro
        }

    }

}
