package projeto.psd.appcontroller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

        String nome = retornaComEncode(req.getParameter("busca"));
        List<Usuario> lista;

        GerenciadorUsuario gu;

        gu = new GerenciadorUsuario();

        lista = gu.readByName(nome);
        
        gu.closeConexao();
        req.setAttribute("encontrados", lista);

        RequestDispatcher desp = req.getRequestDispatcher("Busca.jsp");
        desp.forward(req, res);

    }

    private String retornaComEncode(String value) throws UnsupportedEncodingException {
        return new String(value.getBytes(), "UTF-8");
    }
}
