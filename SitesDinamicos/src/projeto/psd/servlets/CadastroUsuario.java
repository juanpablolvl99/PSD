
package projeto.psd.servlets;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import projeto.psd.entidades.Usuario;
import projeto.psd.gerenciadores.GerenciadorUsuario;

@MultipartConfig
public class CadastroUsuario extends HttpServlet{
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Servlet Iniciado");
    }

    @Override
    public void destroy() {
        super.destroy();
        log("Servlet Finalizado");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Usuario usu = new Usuario();
        List<Part> lista = (List) req.getParts();

        usu.setLogin(req.getParameter("login"));
        usu.setSenha(req.getParameter("senha"));
        usu.setNome(req.getParameter("nome"));
        usu.setApelido(req.getParameter("apelido"));
        usu.setDataDeNascimento(req.getParameter("dataDeNascimento"));
        usu.setCidade(req.getParameter("cidade"));
        usu.setEmail(req.getParameter("email"));
        usu.setProfissao(req.getParameter("profissao"));
        usu.setDescricao(req.getParameter("descricao"));
        usu.setStatus(req.getParameter("status"));
        usu.setCorDoCabelo(req.getParameter("corDoCabelo"));
        usu.setPassatempos(req.getParameter("passatempos"));
        
        PrintWriter pw = resp.getWriter();
        
        String appPath = req.getServletContext().getRealPath("");
        String uploadPath = appPath + "imagens" + File.separator + usu.getLogin();
        
        File uploadDirs = new File(uploadPath);
        
        if(!uploadDirs.exists())
            uploadDirs.mkdirs();
        
        for (Part p : lista) {
            if(p.getName().equals("altura")){
                usu.setAltura(Double.parseDouble(getValue(p)));
            }
            if(p.getName().equals("peso")){
                usu.setPeso(Double.parseDouble(getValue(p)));
            }
            if(p.getName().equals("fotoPerfil")){
                usu.setFotoPerfil(p.getSubmittedFileName());
                p.write(uploadPath + File.separator + p.getSubmittedFileName());
            }
        }
        
        GerenciadorUsuario ger = new GerenciadorUsuario();
        
        try {
            if (ger.add(usu)){
                RequestDispatcher despachante = req.getRequestDispatcher("index.htm");
                despachante.forward(req, resp);
            } else {
                pw.print("tendi");
            }
        } catch (ClassNotFoundException ex) {
            pw.print(ex.getMessage());
        } catch (SQLException ex) {
            pw.print(ex.getMessage());
        }
    }
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp){
        
    }
    
    private String getValue(Part part) throws IOException {
        try (
            BufferedReader buffer = new BufferedReader(new InputStreamReader(part.getInputStream()))) {
            return buffer.lines().collect(Collectors.joining("\n"));
        }
    }

}    