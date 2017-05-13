package projeto.psd.appcontroller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import projeto.psd.entidades.Usuario;
import projeto.psd.gerenciadores.GerenciadorUsuario;
import projeto.psd.interfaces.Command;

public class LoginController implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, 
    ServletException{
        
        String login = req.getParameter("login");
        String senha = req.getParameter("senha");
        GerenciadorUsuario ger;
        List<Usuario> lista;
        Usuario user = null;
        HttpSession sessao = req.getSession(true);

        ger = new GerenciadorUsuario();
        lista = ger.listAll();
        boolean condicao = false;

        for (Usuario u : lista) {
            if (u.getLogin().equals(login) && u.getSenha().equals(senha)) {
                user = ger.readByEmail(u.getEmail());
                condicao = true;
                break;
            }
        }
        if (condicao) {
            synchronized (sessao) {
                sessao.setAttribute("emailUsuario", user.getEmail());
                sessao.setAttribute("loginUsuario", login);
                sessao.setAttribute("senhaUsuario", senha);
                sessao.setAttribute("dadosUsu", user);
            }
            ger.closeConexao();
            String url = res.encodeRedirectURL("Inicial.jsp");
            req.getRequestDispatcher(url).forward(req, res);
        } else {
            ger.closeConexao();
            res.sendRedirect("Index.htm");
        }
    }

}
