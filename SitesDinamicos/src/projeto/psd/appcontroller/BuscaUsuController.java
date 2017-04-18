
package projeto.psd.appcontroller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projeto.psd.entidades.Usuario;
import projeto.psd.gerenciadores.GerenciadorUsuario;
import projeto.psd.interfaces.Command;

public class BuscaUsuController implements Command{

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, ServletException {
        
        String email = req.getParameter("email");
        
        GerenciadorUsuario ger;
        ger = new GerenciadorUsuario();
        Usuario user = ger.readByEmail(email);
        
        req.setAttribute("user", user);
        
        RequestDispatcher despachante = req.getRequestDispatcher("informUsu.jsp");
        despachante.forward(req, res);
        
    }
    
}
