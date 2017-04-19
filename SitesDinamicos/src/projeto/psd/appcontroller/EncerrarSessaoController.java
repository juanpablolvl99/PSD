package projeto.psd.appcontroller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import projeto.psd.interfaces.Command;

public class EncerrarSessaoController implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException,
            ServletException {
        
        HttpSession sessao = req.getSession(false);
        synchronized (sessao) {
            sessao.invalidate();
        }
    
        res.sendRedirect("Index.htm");
        
    }

}
