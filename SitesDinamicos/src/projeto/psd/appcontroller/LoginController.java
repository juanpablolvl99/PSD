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
        Usuario auxiliar = new Usuario();
        HttpSession sessao = req.getSession(true);

        ger = new GerenciadorUsuario();
        lista = ger.listAll();
        boolean condicao = false;

        for (Usuario u : lista) {
            if (u.getLogin().equals(login) && u.getSenha().equals(senha)) {
                auxiliar.setNome(u.getNome());
                auxiliar.setApelido(u.getApelido());
                auxiliar.setDataDeNascimento(u.getDataDeNascimento());
                auxiliar.setCidade(u.getCidade());
                auxiliar.setEmail(u.getEmail());
                auxiliar.setProfissao(u.getProfissao());
                auxiliar.setDescricao(u.getDescricao());
                auxiliar.setStatus(u.getStatus());
                auxiliar.setAltura(u.getAltura());
                auxiliar.setPeso(u.getPeso());
                auxiliar.setCorDoCabelo(u.getCorDoCabelo());
                auxiliar.setPassatempos(u.getPassatempos());
                auxiliar.setFotoPerfil(u.getFotoPerfil());
                condicao = true;
                break;
            }
        }
        if (condicao) {
            synchronized (sessao) {
                sessao.setAttribute("emailUsuario", auxiliar.getEmail());
                sessao.setAttribute("loginUsuario", login);
                sessao.setAttribute("senhaUsuario", senha);
                sessao.setAttribute("dadosUsu", auxiliar);
            }
            String url = res.encodeRedirectURL("inicial.jsp");
            res.sendRedirect(url);
        } else {
            res.sendRedirect("index.htm");
        }
    }

}
