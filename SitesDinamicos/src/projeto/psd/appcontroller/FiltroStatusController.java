
package projeto.psd.appcontroller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projeto.psd.entidades.Usuario;
import projeto.psd.gerenciadores.GerenciadorUsuario;
import projeto.psd.interfaces.Command;

public class FiltroStatusController implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, ServletException {
        String status = req.getParameter("status");
        String resultado = status + "%";
        GerenciadorUsuario ger = new GerenciadorUsuario();
        List<Usuario> lista = ger.filtroStatus(resultado);
        req.setAttribute("filtro", lista);
        ger.closeConexao();
        RequestDispatcher despachante = req.getRequestDispatcher("Filtro.jsp");
        despachante.forward(req, res);
    }
    
}
