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

public class BuscadorController implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException,
            ServletException {

        String nome = req.getParameter("busca");
        List<Usuario> lista;

        GerenciadorUsuario gu;

        gu = new GerenciadorUsuario();

        lista = gu.readByName(nome);

        req.setAttribute("encontrados", lista);

        RequestDispatcher desp = req.getRequestDispatcher("Busca.jsp");
        desp.forward(req, res);

    }

}
