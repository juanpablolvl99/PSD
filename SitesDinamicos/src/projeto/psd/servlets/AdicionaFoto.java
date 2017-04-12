package projeto.psd.servlets;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import projeto.psd.gerenciadores.GerenciadorGaleria;

@MultipartConfig
public class AdicionaFoto extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        try{
            Part part = req.getPart("foto");

            GerenciadorGaleria gg = new GerenciadorGaleria(); // ..gg gigante

            HttpSession session = req.getSession(false);
            String path = req.getServletContext().getRealPath("");
            String email, login;

            synchronized (session) {
                email = (String) session.getAttribute("emailUsuario");
                login = (String) session.getAttribute("loginUsuario");
            }

            String uploadPath = path + "imagens" + File.separator + login;
            String alternativePath = "imagens" + File.separator + login;
            
            String filePath = uploadPath + File.separator + part.getSubmittedFileName();
            String AltFilePath = alternativePath +  File.separator + part.getSubmittedFileName();
            
            File file = new File(filePath);

            if (!file.exists()) {
                gg.add(email, AltFilePath);
                part.write(filePath);
            }else{
                //decidir oq sera feito;
            }
            
            List<String> fotos = gg.listAll(email);
            req.setAttribute("list", fotos);
            
            RequestDispatcher rd = req.getRequestDispatcher("Galeria.jsp");
            rd.forward(req, res);

        } catch (IOException ex) {
            res.getWriter().print(ex);
        } catch (ServletException ex) {
            res.getWriter().print(ex);
        } catch (SQLException ex) {res.getWriter().print(ex);
        } catch (ClassNotFoundException ex) {res.getWriter().print(ex);
        }

    }

}
