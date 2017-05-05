package projeto.psd.appcontroller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projeto.psd.gerenciadores.GerenciadorRelacionamento;
import projeto.psd.interfaces.Command;

public class ExcluirRelacionamentoController implements Command{

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, ServletException {
        
        GerenciadorRelacionamento gr = new GerenciadorRelacionamento();
        
        //if(gr.remove(userEmail, userPara))
        
    }
    
}
