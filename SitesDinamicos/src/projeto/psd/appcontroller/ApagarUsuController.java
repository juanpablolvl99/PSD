package projeto.psd.appcontroller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projeto.psd.gerenciadores.GerenciadorRelacionamento;
import projeto.psd.gerenciadores.GerenciadorUsuario;
import projeto.psd.interfaces.Command;

public class ApagarUsuController implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, ServletException {
        
        String email = (String) req.getSession(false).getAttribute("emailUsuario");
        String login = (String) req.getSession(false).getAttribute("loginUsuario");
        String senha = req.getParameter("senha");

        GerenciadorUsuario ger;
        ger = new GerenciadorUsuario();

        if (ger.remove(login, senha)){
            File file =  new File(req.getServletContext().getRealPath("") + "imagens/" + login);
            limparPasta(file);
            file.delete();
            String url = "Index.htm";
//            GerenciadorRelacionamento gr = new GerenciadorRelacionamento();
//        
//            gr.remove2(email);
            ger.closeConexao();
            res.sendRedirect(url);
        } else {
            ger.closeConexao();
            res.sendError(333);
        }

    }
    
    public void limparPasta(File file){
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for (File f : files) {
                limparPasta(f);
            }
        }else{
            file.delete();
        }
    };

}
