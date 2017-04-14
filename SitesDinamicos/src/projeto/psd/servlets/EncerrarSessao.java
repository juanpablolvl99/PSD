
package projeto.psd.servlets;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EncerrarSessao extends HttpServlet{
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{

        HttpSession sessao = req.getSession(false);
        synchronized(sessao){
            sessao.invalidate();
            
        }
        try {
            resp.sendRedirect("index.htm");
        } catch (IOException ex) {
            resp.getWriter().print(ex);
        }

    }
    
}
