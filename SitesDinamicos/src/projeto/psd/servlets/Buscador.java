package projeto.psd.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import projeto.psd.entidades.Usuario;
import projeto.psd.gerenciadores.GerenciadorUsuario;

public class Buscador extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {

        String nome = req.getParameter("busca");
        List<Usuario> lista = null;

        GerenciadorUsuario gu;

        try {

            gu = new GerenciadorUsuario();
            
            lista = gu.read(nome);

            req.setAttribute("encontrados", lista);
            
            RequestDispatcher desp = req.getRequestDispatcher("Busca.jsp");
            try {
                desp.forward(req, resp);
            } catch (ServletException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            
            

        } catch (ClassNotFoundException ex) {
            //redirecionar para pagina de erro
        } catch (SQLException ex) {
            //redirecionar para pagina de erro
        //} catch (IOException ex) {
            //redirecionar para pagina de erro
        }

    }

}
