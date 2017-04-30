package projeto.psd.appcontroller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projeto.psd.gerenciadores.GerenciadorRecom;
import projeto.psd.interfaces.Command;

public class ExcluirRecoController implements Command{

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, ServletException {
    
        String recomendadoEmail = req.getParameter("recomendadoEmail");
        String paraEmail = req.getParameter("paraEmail");
        
        GerenciadorRecom gr = new GerenciadorRecom();
        
        if(gr.remove(recomendadoEmail, paraEmail)){
            gr.closeConexao();
            res.sendRedirect("Inicial.jsp");
        }else{
            res.sendError(333);
        }
        
    }
    
}
