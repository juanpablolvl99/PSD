package projeto.psd.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projeto.psd.gerenciadores.GerenciadorUsuario;

@WebServlet("/cadastro")
public class CadastroUsuario extends HttpServlet {

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
        String login = req.getParameter("login");
        String senha = req.getParameter("senha");
        String nome = req.getParameter("nome");
        String apelido = req.getParameter("apelido");
        String dataDeNascimento = req.getParameter("nascimento");
        String cidade = req.getParameter("cidade");
        String email = req.getParameter("email");
        String profissao = req.getParameter("profissao");
        String descricao = req.getParameter("descricao");
        String status = req.getParameter("status");
        double altura = Double.parseDouble(req.getParameter("altura"));
        double peso = Double.parseDouble(req.getParameter("peso"));
        String corDoCabelo = req.getParameter("corCabelo");
        String passatempos = req.getParameter("passatempos");
        String fotoPerfil = req.getParameter("fotoPerfil");
        GerenciadorUsuario ger = new GerenciadorUsuario();
        try {
            if (ger.add(login, senha, nome, apelido, dataDeNascimento, cidade, email, profissao, descricao, status, altura, peso, corDoCabelo, passatempos, fotoPerfil)){
                // Adicionado no BD, redirecionar para a pagina de login
                RequestDispatcher despachante = req.getRequestDispatcher("WEB-INF/login.jsp");
                despachante.forward(req, resp);
            } else {
                /* Definir como vai ser tratado caso não consiga cadastrar usuario, 
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
