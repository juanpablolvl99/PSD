
package projeto.psd.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import projeto.psd.entidades.Usuario;

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
        usu.setDataDeNascimento(req.getParameter("nascimento"));
        usu.setCidade(req.getParameter("cidade"));
        usu.setEmail(req.getParameter("email"));
        usu.setProfissao(req.getParameter("profissao"));
        usu.setDescricao(req.getParameter("descricao"));
        usu.setStatus(req.getParameter("status"));
        usu.setCorDoCabelo(req.getParameter("corCabelo"));
        usu.setPassatempos(req.getParameter("passatempos"));
        
        PrintWriter pw = resp.getWriter();
        
        for (Part p : lista) {
            if(p.getName().equals("altura")){
                usu.setAltura(Double.parseDouble(getValue(p)));
            }
            if(p.getName().equals("peso")){
                usu.setPeso(Double.parseDouble(getValue(p)));
            }
            if(p.getName().equals("fotoPerfil")){
                usu.setFotoPerfil(p.getSubmittedFileName());
            }
        }
        
//        GerenciadorUsuario ger = new GerenciadorUsuario();
//        try {
//            if (ger.add(usu)){
//                // Adicionado no BD, redirecionar para a pagina de login
//                RequestDispatcher despachante = req.getRequestDispatcher("login.htm");
//                despachante.forward(req, resp);
//            } else {
//                /* Definir como vai ser tratado caso nÃ£o consiga cadastrar usuario, 
//                se vai utilizar um sendError ou um novo despachante. */
//            }
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
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