
package projeto.psd.servlets;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projeto.psd.entidades.Usuario;
import projeto.psd.gerenciadores.GerenciadorUsuario;

/**
 *
 * @author rodri
 */
@WebServlet("/cadastro")
public class CadastroUsuario extends HttpServlet{
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Servlet Iniciado");
    }

    @Override
    public void destroy() {
        super.destroy();
        log("Servlet Finalizado");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Usuario usu = new Usuario();
        usu.setLogin(req.getParameter("login"));
        usu.setSenha(req.getParameter("senha"));
        usu.setNome(req.getParameter("nome"));
        usu.setApelido(req.getParameter("apelido"));
        usu.setDataDeNascimento(req.getParameter("nascimento"));
        usu.setCidade(req.getParameter("cidade"));
        usu.setEmail(req.getParameter("email"));
        usu.setProfissao(req.getParameter("profissao"));
        usu.setDescricao(req.getParameter("descricao"));
        usu.setStatus(req.getParameter("status"));
        usu.setAltura(Double.parseDouble(req.getParameter("altura")));
        usu.setPeso(Double.parseDouble(req.getParameter("peso")));
        usu.setCorDoCabelo(req.getParameter("corCabelo"));
        usu.setPassatempos(req.getParameter("passatempos"));
        // Tratamento da foto
	// String fotoPerfil = req.getParameter("fotoPerfil");
        GerenciadorUsuario ger = new GerenciadorUsuario();
        try {
            if (ger.add(usu)){
                // Adicionado no BD, redirecionar para a pagina de login
                RequestDispatcher despachante = req.getRequestDispatcher("WEB-INF/login.jsp");
                despachante.forward(req, resp);
            } else {
                /* Definir como vai ser tratado caso nÃ£o consiga cadastrar usuario, 
                se vai utilizar um sendError ou um novo despachante. */
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp){
        
    }
    
}
