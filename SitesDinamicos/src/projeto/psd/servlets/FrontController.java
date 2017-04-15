package projeto.psd.servlets;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projeto.psd.interfaces.Command;

public class FrontController extends HttpServlet{
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res){
        
    }
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res){
        
        String action = req.getParameter("action");
        try {
            Command command = (Command) Class.forName("projeto.psd.appcontroller." + action + "Controller").newInstance();
            command.execute(req, res);  
        } catch (ClassNotFoundException ex) {
            //enviar pra pagina de erro
        } catch (InstantiationException ex) {
            //enviar pra pagina de erro
        } catch (IllegalAccessException ex) {
            //enviar pra pagina de erro
        } catch (SQLException ex) {
            //enviar pra pagina de erro
        } catch (IOException ex) {
            //enviar pra pagina de erro            
        } catch (ServletException ex) {
            //enviar pra pagina de erro            
        }
        
    }
    
}
