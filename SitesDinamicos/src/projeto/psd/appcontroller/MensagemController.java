package projeto.psd.appcontroller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projeto.psd.entidades.Mensagem;
import projeto.psd.gerenciadores.GerenciadorMensagem;
import projeto.psd.interfaces.Command;

public class MensagemController implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException,
            ServletException {

        String mensagem = retornaComEncode(req.getParameter("mensagem"));
        String emailDe = retornaComEncode(req.getParameter("emailDe"));
        String emailPara = retornaComEncode(req.getParameter("emailPara"));

        Mensagem msg = new Mensagem();
        msg.setDeEmail(emailDe);
        msg.setParaEmail(emailPara);
        msg.setMensagem(mensagem);

        GerenciadorMensagem gm = new GerenciadorMensagem();
        if (gm.add(msg)) {
            gm.closeConexao();

            if (!req.getParameter("pagina").equals("Mensagens.jsp")) {
                res.sendRedirect("Inicial.jsp");
            } else {
                res.sendRedirect("Mensagens.jsp");
            }

        } else {
            //
        };

    }

    private String retornaComEncode(String value) throws UnsupportedEncodingException {
        return new String(value.getBytes(), "UTF-8");
    }

}
