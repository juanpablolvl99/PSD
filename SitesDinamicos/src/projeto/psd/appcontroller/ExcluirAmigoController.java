package projeto.psd.appcontroller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projeto.psd.entidades.Mensagem;
import projeto.psd.gerenciadores.GerenciadorAmizade;
import projeto.psd.gerenciadores.GerenciadorMensagem;
import projeto.psd.interfaces.Command;

public class ExcluirAmigoController implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, ServletException {

        String amigoEmail = req.getParameter("amigoEmail");
        String userEmail = req.getParameter("userEmail");

        List<Mensagem> lista;

        GerenciadorAmizade ga = new GerenciadorAmizade();
        GerenciadorMensagem gm = new GerenciadorMensagem();

        if (ga.remove(userEmail, amigoEmail)) {

            lista = gm.listAll(userEmail);

            for (Mensagem mensagem : lista) {
                if (mensagem.getDeEmail().equals(amigoEmail)) {
                    gm.remove(mensagem.getId());
                }
            }

            lista = gm.listAll(amigoEmail);

            for (Mensagem mensagem : lista) {
                if (mensagem.getDeEmail().equals(userEmail)) {
                    gm.remove(mensagem.getId());
                }
            }

            gm.closeConexao();
            ga.closeConexao();

            res.sendRedirect("InformUsu.jsp?current=" + amigoEmail);
        } else {
            gm.closeConexao();
            ga.closeConexao();
            res.sendError(333);
        }

    }

}
