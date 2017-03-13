
package projeto.psd.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import projeto.psd.entidades.Usuario;
import projeto.psd.gerenciadores.GerenciadorUsuario;

@WebServlet("/login")
public class LoginUsuario extends HttpServlet{
    
    @Override
    public void init (ServletConfig config) throws ServletException{
        super.init(config);
        log("Servlet Iniciado");
    }
    
    @Override
    public void destroy(){
        super.destroy();
        log("Servlet Finalizado");
    }
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String login = req.getParameter("login");
        String senha = req.getParameter("senha");
        GerenciadorUsuario ger = new GerenciadorUsuario();
        List<Usuario> lista = new ArrayList<Usuario>();
        try {
            lista = ger.listAll();
            boolean condicao = false;
            for (Usuario u: lista){
                if(u.getLogin().equals(login) && u.getSenha().equals(senha)){
                    condicao = true;
                }
            }
            if (condicao){
                HttpSession sessao = req.getSession(true);
                synchronized(sessao){
                    sessao.setAttribute("loginUsuario", login);
                    sessao.setAttribute("senhaUsuario", senha);
                }
                // Especificar o caminho que vai ser despachado 
                RequestDispatcher despachante = req.getRequestDispatcher("");
                despachante.forward(req, resp);
            } else {
                /* Definir como vai ser tratado caso não consiga autenticar, 
                se vai utilizar um sendError ou um novo despachante. */
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
}
