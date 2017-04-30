package projeto.psd.appcontroller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import projeto.psd.gerenciadores.GerenciadorGaleria;
import projeto.psd.interfaces.Command;

public class AdicionarFotoController implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException,
            ServletException {

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
        String AltFilePath = alternativePath + File.separator + part.getSubmittedFileName();

        File file = new File(filePath);

        Calendar c = Calendar.getInstance();
        Date d = new Date(c.getTime().getTime());
        
        if (!file.exists()) {
            gg.add(email, AltFilePath, d);
            part.write(filePath);
        } else {
            res.sendError(333);
        }

        gg.closeConexao();
        RequestDispatcher rd = req.getRequestDispatcher("Inicial.jsp");
        rd.forward(req, res);
    }

}
