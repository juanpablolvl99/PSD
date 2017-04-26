package projeto.psd.appcontroller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projeto.psd.gerenciadores.GerenciadorMensagem;
import projeto.psd.interfaces.Command;

public class ExcluirMensagemController implements Command{

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, 
            ServletException {
        
        int id = Integer.parseInt(req.getParameter("id"));
        
        GerenciadorMensagem gm = new GerenciadorMensagem();
        
        boolean vrf = gm.remove(id);
        
        gm.closeConexao();
        
        if(vrf){
            res.sendRedirect("Mensagens.jsp");
        }else{
            //
        }
    }
    
}
