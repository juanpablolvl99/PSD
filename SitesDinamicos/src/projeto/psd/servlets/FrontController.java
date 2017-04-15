package projeto.psd.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projeto.psd.interfaces.Command;

@MultipartConfig
public class FrontController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) {

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) {

        res.setCharacterEncoding("utf-8");
        PrintWriter pw = null;

        String action = req.getParameter("action");
        try {
            pw = res.getWriter();

            Command command = (Command) Class.forName("projeto.psd.appcontroller." + action + "Controller").newInstance();
            command.execute(req, res);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException | IOException
                | ServletException ex) {
            pw.print(ex);
        }

    }

}
