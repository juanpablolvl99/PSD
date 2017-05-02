
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

public class FiltroGeralController implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, ServletException {
        String cor = req.getParameter("corDoCabelo");
        String status = retornaComEncode(req.getParameter("status"));
        String resultado;
        List<Usuario> lista;
        
        GerenciadorUsuario ger = new GerenciadorUsuario();
        
        if(!status.equals("")){
            resultado = status + "%";
            if(!cor.equals(""))
                lista = ger.filtroGeral(cor, resultado);
            else
                lista = ger.filtroStatus(resultado);
        }else
            lista = ger.filtroCor(cor);
            
        req.setAttribute("encontrados", lista);
        ger.closeConexao();
        RequestDispatcher despachante = req.getRequestDispatcher("Busca.jsp");
        despachante.forward(req, res);
    }    
    
    private String retornaComEncode(String value) throws UnsupportedEncodingException {
        return new String(value.getBytes(), "UTF-8");
    }
    
}
